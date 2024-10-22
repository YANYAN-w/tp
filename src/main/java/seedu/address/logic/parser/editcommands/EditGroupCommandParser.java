package seedu.address.logic.parser.editcommands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_GROUP_NAME;

import java.util.List;

import seedu.address.logic.commands.editcommands.EditGroupCommand;
import seedu.address.logic.commands.editcommands.EditGroupCommand.EditGroupDescriptor;
import seedu.address.logic.parser.ArgumentMultimap;
import seedu.address.logic.parser.ArgumentTokenizer;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.ParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.group.GroupName;

/**
 * Parses input arguments and creates a new EditGroupCommand object
 */
public class EditGroupCommandParser implements Parser<EditGroupCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditGroupCommand
     * and returns an EditGroupCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditGroupCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap =
            ArgumentTokenizer.tokenize(args, PREFIX_GROUP_NAME);

        List<String> groupNames = argMultimap.getAllValues(PREFIX_GROUP_NAME);
        if (groupNames.size() > 2) {
            throw new ParseException(String.format(EditGroupCommand.MESSAGE_INVALID_COMMAND_FORMAT, groupNames.size()));
        }
        if (groupNames.size() == 1) {
            throw new ParseException(EditGroupCommand.MESSAGE_NOT_EDITED);
        }
        EditGroupDescriptor editGroupDescriptor = new EditGroupDescriptor();
        GroupName originalGroupName = ParserUtil.parseGroupName(groupNames.get(0));
        GroupName updatedGroupName = ParserUtil.parseGroupName(groupNames.get(1));
        editGroupDescriptor.setGroupName(updatedGroupName);
        return new EditGroupCommand(originalGroupName, editGroupDescriptor);
    }
}