package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DETAILS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.order.Details;
import seedu.address.model.order.Order;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.PhoneContainsKeywordsPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Changes the remark of an existing person in ReadyBakey.
 */
public class AddOrderCommand extends Command {

    public static final String COMMAND_WORD = "addo";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds an order to ReadyBakey. "
            + "Parameters: "
            + PREFIX_PHONE + "PHONE "
            + PREFIX_DETAILS + "DETAILS \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_PHONE + "98765432 "
            + PREFIX_DETAILS + "1x Jerry Favourite Cheese Cake";

    public static final String MESSAGE_ORDER_SUCCESS = "New order added: %1$s";
    public static final String MESSAGE_DUPLICATE_ORDER = "This order already exists in the address book";

    private final Details details;
    private final Phone phone;

    /**
     * Creates an AddOrderCommand to add the specified {@code Order}
     */
    public AddOrderCommand(Details details, Phone phone) {
        requireAllNonNull(details,phone);
        this.details = details;
        this.phone = phone;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        ArrayList<String> phoneKeywords = new ArrayList<String>();
        phoneKeywords.add(phone.value);
        Person p = model.getFilteredPersonList().filtered(new PhoneContainsKeywordsPredicate(phoneKeywords)).get(0);
        UUID uuid = p.getUuid();
        Order toAdd = new Order(phone,details,uuid);

        if (model.hasOrder(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_ORDER);
        }

        model.addOrder(toAdd);
        return new CommandResult(String.format(MESSAGE_ORDER_SUCCESS, toAdd), true, false);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddOrderCommand // instanceof handles nulls
                && details.equals(((AddOrderCommand) other).details)
                && phone.equals(((AddOrderCommand) other).phone));
    }
}
