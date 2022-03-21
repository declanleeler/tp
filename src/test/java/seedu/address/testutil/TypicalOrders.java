package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DETAILS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DETAILS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.order.Order;

public class TypicalOrders {
    public static final Order EMILY = new OrderBuilder().withName("Emily Lee")
            .withAddress("BLK 123 Ang Mo Kio Ave 4, #05-12")
            .withPhone("94231333")
            .withDetails("1xvanillacake")
            .withComplete(false).build();

    public static final Order SIMON = new OrderBuilder().withName("Simon Loo")
            .withAddress("55 Serangoon Avenue 3")
            .withPhone("94241423")
            .withDetails("1xchocolatecake")
            .withComplete(false).build();

    public static final Order JERRY = new OrderBuilder().withName("Jerry Mouse")
            .withAddress("55 Ang Mo Kio Avenue 38")
            .withPhone("91029382")
            .withDetails("1xjerryfavouritecheesecake")
            .withComplete(false).build();


    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Order AMY = new OrderBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withDetails(VALID_DETAILS_AMY).withAddress(VALID_ADDRESS_AMY)
            .build();
    public static final Order BOB = new OrderBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withDetails(VALID_DETAILS_BOB).withAddress(VALID_ADDRESS_BOB)
            .build();

    private TypicalOrders() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical orders.
     */
    public static AddressBook getTypicalAddressBookOrders() {
        AddressBook ab = new AddressBook();
        for (Order order : getTypicalOrders()) {
            ab.addOrder(order);
        }
        return ab;
    }

    public static List<Order> getTypicalOrders() {
        return new ArrayList<>(Arrays.asList(EMILY, SIMON, JERRY));
    }
}