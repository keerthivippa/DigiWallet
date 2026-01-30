package com.orion.DigiWallet.service;

import com.orion.DigiWallet.model.Card;
import com.orion.DigiWallet.repository.CardRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ExtendWith(MockitoExtension.class)
@DisplayName("CardService Unit Tests")
class CardServiceTest {

    @Mock
    private CardRepository cardRepository;

    @InjectMocks
    private CardService cardService;

    // ---------------------------------------------------------
    // REMOVE @Disabled TO ENABLE THE TESTS
//    @Disabled
    @Nested
    @DisplayName("createCard()")
    class CreateCardTests {

        @Test
        @DisplayName("Given new card number when createCard then save and return card")
        void givenNewCardNumber_whenCreateCard_thenSaveAndReturnCard() {

            // GIVEN
            Card card = new Card();
            card.setCardNumber("1234567812345678");

            Mockito.when(cardRepository.existsByCardNumber(card.getCardNumber()))
                    .thenReturn(false);

            Mockito.when(cardRepository.save(card))
                    .thenReturn(card);

            // WHEN
            Card result = cardService.createCard(card);

            // THEN
            assertThat(result).isNotNull();
            Mockito.verify(cardRepository).save(card);
        }

        @Test
        @DisplayName("Given existing card number when createCard then throw exception")
        void givenExistingCardNumber_whenCreateCard_thenThrowException() {

            // GIVEN
            Card card = new Card();
            card.setCardNumber("1234567812345678");

            Mockito.when(cardRepository.existsByCardNumber(card.getCardNumber()))
                    .thenReturn(true);

            // WHEN / THEN
            assertThatThrownBy(() -> cardService.createCard(card))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("Card number already exists");

            Mockito.verify(cardRepository, Mockito.never()).save(Mockito.any());
        }
    }

    // ---------------------------------------------------------
    // REMOVE @Disabled TO ENABLE THE TESTS
//    @Disabled
    @Nested
    @DisplayName("getCardById()")
    class GetCardByIdTests {

        @Test
        @DisplayName("Given existing card id when getCardById then return card")
        void givenExistingCardId_whenGetCardById_thenReturnCard() {

            // GIVEN
            Card card = new Card();
            card.setId(1L);

            Mockito.when(cardRepository.findById(1L))
                    .thenReturn(Optional.of(card));

            // WHEN
            Card result = cardService.getCardById(1L);

            // THEN
            assertThat(result).isNotNull();
            assertThat(result.getId()).isEqualTo(1L);
        }

        @Test
        @DisplayName("Given non-existing card id when getCardById then throw exception")
        void givenNonExistingCardId_whenGetCardById_thenThrowException() {

            // GIVEN
            Mockito.when(cardRepository.findById(1L))
                    .thenReturn(Optional.empty());

            // WHEN / THEN
            assertThatThrownBy(() -> cardService.getCardById(1L))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("Card not found with id: 1");
        }
    }

    // ---------------------------------------------------------
    // REMOVE @Disabled TO ENABLE THE TESTS
//    @Disabled
    @Nested
    @DisplayName("updateCard()")
    class UpdateCardTests {

        @Test
        @DisplayName("Given existing card when updateCard then update and return card")
        void givenExistingCard_whenUpdateCard_thenUpdateAndReturnCard() {

            // GIVEN
            Card existingCard = new Card();
            existingCard.setId(1L);

            Card updatedCard = new Card();
            updatedCard.setCardType("VIRTUAL");
            updatedCard.setStatus("BLOCKED");
            updatedCard.setExpiryDate(LocalDate.of(2030, 12, 31));

            Mockito.when(cardRepository.findById(1L))
                    .thenReturn(Optional.of(existingCard));

            Mockito.when(cardRepository.save(existingCard))
                    .thenReturn(existingCard);

            // WHEN
            Card result = cardService.updateCard(1L, updatedCard);

            // THEN
            assertThat(result.getCardType()).isEqualTo("VIRTUAL");
            assertThat(result.getStatus()).isEqualTo("BLOCKED");
            assertThat(result.getExpiryDate()).isEqualTo(LocalDate.of(2030, 12, 31));
        }

        @Test
        @DisplayName("Given non-existing card when updateCard then throw exception")
        void givenNonExistingCard_whenUpdateCard_thenThrowException() {

            // GIVEN
            Mockito.when(cardRepository.findById(1L))
                    .thenReturn(Optional.empty());

            // WHEN / THEN
            assertThatThrownBy(() -> cardService.updateCard(1L, new Card()))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("Card not found with id: 1");
        }
    }

    // ---------------------------------------------------------
    // REMOVE @Disabled TO ENABLE THE TESTS
//    @Disabled
    @Nested
    @DisplayName("deleteCard()")
    class DeleteCardTests {

        @Test
        @DisplayName("Given existing card id when deleteCard then delete successfully")
        void givenExistingCardId_whenDeleteCard_thenDeleteSuccessfully() {

            // GIVEN
            Mockito.when(cardRepository.existsById(1L))
                    .thenReturn(true);

            // WHEN
            cardService.deleteCard(1L);

            // THEN
            Mockito.verify(cardRepository).deleteById(1L);
        }

        @Test
        @DisplayName("Given non-existing card id when deleteCard then throw exception")
        void givenNonExistingCardId_whenDeleteCard_thenThrowException() {

            // GIVEN
            Mockito.when(cardRepository.existsById(1L))
                    .thenReturn(false);

            // WHEN / THEN
            assertThatThrownBy(() -> cardService.deleteCard(1L))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("Card not found with id: 1");

            Mockito.verify(cardRepository, Mockito.never()).deleteById(Mockito.any());
        }
    }
}
