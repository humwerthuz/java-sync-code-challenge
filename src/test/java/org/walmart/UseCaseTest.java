package org.walmart;

import static org.junit.jupiter.api.Assertions.*;

class UseCaseTest {


    @org.junit.jupiter.api.Test
    void Process_OrderValidation_True() {
        Message msg1 = new Message(1, "");
        Message msg2 = new Message(2, "");
        UseCase useCase = new UseCase();
        assertAll(() -> useCase.process(msg1));
        assertAll(() -> useCase.process(msg2));
    }

    @org.junit.jupiter.api.Test
    void Process_OrderValidation_ThrowsDuplicated() {
        Message msg1 = new Message(1, "");
        Message msg2 = new Message(1, "");
        UseCase useCase = new UseCase();
        assertAll(() -> useCase.process(msg1));
        assertThrows(Exception.class, () ->  useCase.process(msg2));
    }

    @org.junit.jupiter.api.Test
    void Process_OrderValidation_ThrowsOutOfOrder() {
        Message msg1 = new Message(2, "");
        Message msg2 = new Message(1, "");
        UseCase useCase = new UseCase();
        assertAll(() -> useCase.process(msg1));
        assertThrows(Exception.class, () ->  useCase.process(msg2));
    }
}