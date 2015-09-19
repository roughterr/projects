package org.nau;

import java.util.Optional;

/**
 * Created by Roman on 19.09.2015.
 */
public interface DoublyLinkedListElementIntf {
    Optional<DoublyLinkedListElementIntf> getPreviousElement();

    Optional<DoublyLinkedListElementIntf> getNextElement();

    Integer getValue();
}
