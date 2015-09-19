package org.nau;

import java.util.Optional;

/**
 * Created by Roman on 19.09.2015.
 */
public class DoublyLinkedListElementOperations {
    public DoublyLinkedListElementIntf constructNewElement(final Optional<DoublyLinkedListElementIntf> previousElement,
                                                           final Optional<DoublyLinkedListElementIntf> nextElement,
                                                           final Integer value) {
        return new DoublyLinkedListElementIntf() {
            public Optional<DoublyLinkedListElementIntf> getPreviousElement() {
                return previousElement;
            }

            public Optional<DoublyLinkedListElementIntf> getNextElement() {
                return nextElement;
            }

            public Integer getValue() {
                return value;
            }
        };
    }

    /**
     * передній елемент елементу №1 втрачається.
     * задній елемент елементу №2 втрачається.
     * @param firstElement  елемент №1. до нього буде приєднаний елемент №2 спереду
     * @param secondElement елемент №2. до нього буде приєднаний елемент №1 ззаду
     * @return
     */
    public DoublyLinkedListElementIntf glueTogether(final DoublyLinkedListElementIntf firstElement,
                                                    final DoublyLinkedListElementIntf secondElement) {
        //всі елементи будуть перестворені заново
        final DoublyLinkedListElementIntf newFirstElement = new DoublyLinkedListElementIntf() {
            public Optional<DoublyLinkedListElementIntf> getPreviousElement() {
                return previousElement;
            }

            private Optional<DoublyLinkedListElementIntf> getOptionalFirstElement() {
                return (Optional<DoublyLinkedListElementIntf>) (Object) Optional.of(this);
            }

            public Optional<DoublyLinkedListElementIntf> getNextElement() {
                return new DoublyLinkedListElementIntf() {
                    public Optional<DoublyLinkedListElementIntf> getPreviousElement() {
                        return getOptionalFirstElement();
                    }

                    private Optional<DoublyLinkedListElementIntf> getOptionalSecondElement() {
                        return (Optional<DoublyLinkedListElementIntf>) (Object) Optional.of(this);
                    }

                    public Optional<DoublyLinkedListElementIntf> getNextElement() {
                        return nextElement;//TODO
                    }

                    public Integer getValue() {
                        return secondElement.getValue();
                    }
                };
            }

            public Integer getValue() {
                return firstElement.getValue();
            }
        };
        return null;
    }
}
