package seedu.address.logic.parser.sortcommands;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.sortcommands.SortStudentCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new SortStudentCommand object.
 */
public class SortStudentCommandParser implements Parser<SortStudentCommand> {

    /**
     * Parses the given {@code String} of arguments and returns an SortStudentCommand object for execution.
     *
     * @throws ParseException if the user input does not conform the expected format.
     */
    public SortStudentCommand parse(String args) throws ParseException {
        if (!args.trim().equals("")) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortStudentCommand.MESSAGE_USAGE));
        }
        return new SortStudentCommand();
    }

}
