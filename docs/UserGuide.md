---
  layout: default.md
  title: "User Guide"
  pageNav: 3
---

# T_Assistant User Guide

T_Assistant is a **desktop app for CS2103 tutors managing their students, groups and tasks** optimized for use via a
Line Interface (CLI) while still having the benefits of a Graphical User Interface (GUI).

If you can type fast, T_Assistant can get your contact management tasks done faster than traditional GUI apps.

## Navigation

For easy navigation, you can use the navigation breadcrumb on the right side of the website.

If you are on the PDF, use the table of contents below to navigate the site.

<!-- * Table of Contents -->
<page-nav-print />

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `17` or above installed in your Computer.

1. Download the latest `.jar` file from [here](https://github.com/AY2425S1-CS2103-F12-2/tp/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your T_Assistant.

1. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar t_assistant.jar`
   command to run the application.<br>
   *A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.*<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will
   open the help window.<br>
   Some example commands you can try:

    * `list_s` : Lists all students.

    * `as sno/A0123456A sn/James Ho e/e0123456A@u.nus.edu t/TD9` : Adds a student named `James Ho`
      to T_Assistant.

    * `undo` : Undo the last command ran.

    * `clear` : Deletes all contacts.

    * `exit` : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<box type="info" seamless>

**Notes about the command format:**<br>

* Command words are **case-insensitive**!<br>
  `add_s ...` and `ADD_S ...` will both be recognised as commands to add a new student.

* Command words come with **shorthands** <br>
  e.g. `add_s...` and `as...` will both be recognised as commands to add a new student.
* Prefixes are **case-sensitive**!<br>
  e.g. `i/INDEX` will be recognised but `I/INDEX` will not be recognised.

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `as sn/STUDENT_NAME`, `STUDENT_NAME` is a parameter which can be used as `as sn/John Doe`.

* Items in square brackets are **optional**.<br>
  e.g `sn/STUDENT_NAME [t/TAG]` can be used as `sn/John Doe t/TD9` or as `sn/John Doe`.

* Items with `…`​ after them can **be used multiple times including zero times**.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/TD9`, `t/GoodatUI t/TeamLead` etc.

* Parameters can be in **any order**.<br>
  e.g. if the command specifies `sno/STUDENT_NUMBER sn/STUDENT_NAME`, `sn/STUDENT_NAME sno/STUDENT_NUMBER` is also
  acceptable.

* Extraneous parameters for commands that **do not take in parameters** (such as `help`, `list`, `exit` and `clear`)
  will be **ignored**.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

* Extraneous parameters for commands that **do take in parameters** (such as `add_s`, `del_s`) will be recognised as
  *invalid* input parameters.<br>
  e.g. if the command specifies `del_t i/1 gn/CS2103-1-1`, it will be interpreted as a invalid command structure.

**Important**

* If you are using a PDF version of this document, be careful when copying and pasting commands that span multiple lines
  as space characters surrounding line-breaks may be omitted when copied over to the application.
  </box>

--------------------------------------------------------------------------------------------------------------------

### Student Commands

--------------------------------------------------------------------------------------------------------------------

#### Listing Students: `list_s`, `ls`

Shows a list of all students in the T_Assistant.

**Format**: `list_s`

This screenshot shows the result of executing `list_s`.

![list_students](images/screenshots/list_students.png)

--------------------------------------------------------------------------------------------------------------------

#### Adding a Student: `add_s`, `as`

Adds a student to T_Assistant.

**Format**: `add_s/as sno/STUDENT_NUMBER sn/STUDENT_NAME e/EMAIL [t/TAG]...`

##### Notes

1. `Student Number` is the unique identifier for each student, so no 2 students can have the same student number.
2. `Tags` are case-insensitive, so `T1` and `t1` will be recognised as the same tags. T_Assistant will add the first
   instance of the repeated tag.
3. For information on the constraints for each parameter used in this command, go
   to [Command Parameters](#command-parameters).

##### Usage Scenario

###### Scenario #1: Adding `James Ho` to T_Assistant

1. You can begin this command on any panel.
2. Type and execute: `add_s sno/A0123456A sn/James Ho e/e0123456A@u.nus.edu t/TD9`

This screenshot shows the result of executing `add_s sno/A0123456A sn/James Ho e/e0123456A@u.nus.edu t/TD9`.

![add_student](images/screenshots/add_student.png)

--------------------------------------------------------------------------------------------------------------------

#### Deleting a Student: `del_s`, `ds`

Deletes a student from T_Assistant.

**Format**: `del_s sno/STUDENT_NUMBER`

##### Notes

1. A student with the `Student Number` must exist in T_Assistant.
2. For information on the constraints for each parameter used in this command, go
   to [Command Parameters](#command-parameters).

##### Usage Scenario

###### Scenario #1: Deleting `James Ho` from T_Assistant

1. You can begin this command on any panel.
2. Type and execute: `del_s sno/A0123456A`

This screenshot shows the result of executing `del_s sno/A0123456A`.

![delete_student](images/screenshots/del_s.png)

--------------------------------------------------------------------------------------------------------------------

#### Editing a Student: `edit_s`, `es`

Edits the details of a student.

**Format**: `edit_s i/INDEX [sn/NAME] [e/EMAIL] [t/TAG]...`

##### Notes

1. `edit_s` edits the student identified by the index. It only accepts a valid index
   based on the list when `list_s` is called.
2. For information on the constraints for each parameter used in this command, go
   to [Command Parameters](#command-parameters).

##### Usage Scenario

###### Scenario #1: Editing `Bernice Yu`'s Name

1. You can begin this command on any panel.
2. Type and execute: `edit_s i/2 sn/Bernice Yu Ting Kang`

This screenshot shows the result of executing `edit_s i/2 sn/Bernice Yu Ting Kang`.

![edit_student](images/screenshots/edit_s.png)

--------------------------------------------------------------------------------------------------------------------

#### Adding a Student to a Group: `add_s_g`, `asg`

Adds a student to a group.

**Format**: `add_s_g sno/STUDENT_NUMBER gn/GROUP_NAME`

##### Notes

1. The group with the `Group Name` and student with the `Student Number` must both exist in T_Assistant.
2. For information on the constraints for each parameter used in this command, go
   to [Command Parameters](#command-parameters).

##### Usage Scenario

###### Scenario #1: Adding `James Ho` to `CS2103-F11-1`

1. You can begin this command on any panel.
2. Type and execute: `add_s_g sno/A0123456A gn/CS2103-F11-1`

This screenshot shows the result of executing `add_s_g sno/A0123456A gn/CS2103-F11-1`.

![add_s_g](images/screenshots/add_s_g.png)

--------------------------------------------------------------------------------------------------------------------

#### Deleting a Student from a Group: `del_s_g`, `dsg`

Deletes a student from its assigned group.

**Format**: `del_s_g sno/STUDENT_NUMBER`

##### Notes

1. This feature only removes a student from a group, not from T_Assistant.
2. The student must exist in T_Assistant and be in a group.
3. For information on the constraints for each parameter used in this command, go
   to [Command Parameters](#command-parameters).

##### Usage Scenario

###### Scenario #1: Deleting `James Ho` from `CS2103-F11-1`

1. You can begin this command on any panel.
2. Type and execute: `del_s_g sno/A0123456A`

This screenshot shows the result of executing `del_s_g sno/A0123456A`.

![del_s_g](images/screenshots/del_s_g.png)

--------------------------------------------------------------------------------------------------------------------

#### Finding Students: `find_s`, `fs`

Searches T_Assistant for students with fields that match the search query.

**Format**: `find_s q/QUERY [q/QUERY]...`

##### Notes

1. The command will only match full words. You may search for part of a person's name such as `Doe` to find `John Doe`.
   > i.e. `Do` will not match `Doe` and `berniceyu` will not match `berniceyu@u.nus.edu`

2. Searches the following fields that a student has that matches the query:

    * Student name
    * Student number
    * Email
    * Group name
        * **Bonus:** If you wish to filter for students with no groups, use the following command: `find_s q/!nogroup`
      > `!nogroup` is a special query that searches for students with no groups.

<box type="info" seamless>
Take note that if any other student with a group happens to have a field that matches the special keyword, they will also appear in the results.
</box>

2. For information on the constraints for each parameter used in this command, go
   to [Command Parameters](#command-parameters).

##### Usage Scenario

###### Scenario #1: Find students with the following queries - `TD7` and `Oliveiro`

1. You can begin this command on any panel.
2. Type and execute: `find_s q/TD7 q/Olveiro`

This screenshot shows the result of executing `find_s q/TD7 q/Olveiro`.

![find_student](images/screenshots/find_s.png)

###### Scenario #2: Find students with no groups

1. You can begin this command on any panel.
2. Type and execute: `find_s q/!nogroup`

This screenshot shows the result of executing `find_s q/!nogroup`.

![find_student_nogrp.png](images/screenshots/find_s_nogroup.png)

--------------------------------------------------------------------------------------------------------------------

#### Sorting Students: `sort_s`, `ss`

Sorts the list of students in alphabetical order.

**Format**: `sort_s`

This screenshot shows the result of executing `sort_s`.

![sort_s](images/screenshots/sort_s.png)

--------------------------------------------------------------------------------------------------------------------

### Group Commands

--------------------------------------------------------------------------------------------------------------------

#### Listing Groups: `list_g`, `lg`

Explanation of what command does.

**Format**: `list_g`

##### Notes

1. Are there anything that the command cannot do (e.g. cannot change Student Number) or what does it impact (e.g. will
   remove all students from this deleted group)
2. For information on the constraints for each parameter used in this command, go
   to [Command Parameters](#command-parameters).

##### Usage Scenario (for commands that can be overloaded)

Add more scenarios if necessary

###### Scenario #1

This screenshot shows the result of executing `list_g`.

--------------------------------------------------------------------------------------------------------------------

#### Adding a Group: `add_g`, `ag`

Explanation of what command does.

**Format**: `add_g/ag gn/GROUP_NAME [gn/GROUP_NAME]...`

##### Notes

1. Are there anything that the command cannot do (e.g. cannot change Student Number) or what does it impact (e.g. will
   remove all students from this deleted group)
2. For information on the constraints for each parameter used in this command, go
   to [Command Parameters](#command-parameters).

<box type="warning" seamless>

**Caution:**
The command will stop running the moment it hits an error.

For example `add_g gn/CS2103-F11-2 gn/CS2103-F12-2 gn/CS2103-F13-1`

If the group `CS2103-F12-2` already exists in T_Assistant. The command will only still add `CS2103-F11-2` but not `CS2103-F13-1`.

</box>

##### Usage Scenario (for commands that can be overloaded)

Add more scenarios if necessary

###### Scenario #1

This screenshot shows the result of executing `add_g gn/CS2103-F12-2`.

--------------------------------------------------------------------------------------------------------------------

#### Deleting a Group: `del_g`, `dg`

Deletes the specified group from T_Assistant.

**Format**: `del_g gn/GROUP_NAME`

##### Notes

1. This command is case-insensitive.
   > `del_g gn/CS2103-F12-2` and `del_g gn/cs2103-f12-2` will delete the same group.
2. This command will also remove students from the deleted group.
3. For information on the constraints for each parameter used in this command, go
   to [Command Parameters](#command-parameters).

##### Usage Scenario

###### Scenario #1: Deleting a group `CS2103-F12-2`

1. Type and execute: `list_g` to see the list of groups.
2. After finding `CS2103-F12-2`, type and execute: `del_g gn/CS2103-F12-2`

This screenshot shows the result of executing `del_g gn/CS2103-F12-2`.

![del_g.png](images/screenshots/del_g.png)

--------------------------------------------------------------------------------------------------------------------

#### Editing a Group: `edit_g`, `eg`

Explanation of what command does.

**Format**: `edit_g i/INDEX gn/GROUP_NAME`

##### Notes

1. Are there anything that the command cannot do (e.g. cannot change Student Number) or what does it impact (e.g. will
   remove all students from this deleted group)
2. For information on the constraints for each parameter used in this command, go
   to [Command Parameters](#command-parameters).

##### Usage Scenario (for commands that can be overloaded)

Add more scenarios if necessary

###### Scenario #1

This screenshot shows the result of executing `edit_g i/1 gn/CS2103-F12-3`.

--------------------------------------------------------------------------------------------------------------------

#### Finding Groups: `find_g`, `fg`

Searches T_Assistant for groups with fields that match the search query.

**Format**: `find_g q/QUERY [q/QUERY]...`

##### Notes

1. This command is case-insensitive.
2. The command will match substrings. You may search for part of a group's name such as `F12` to find `CS2103T-F12-10`.
3. Searches the following field that a group has that matches the query:
    * Group name
4. For information on the constraints for each parameter used in this command, go
   to [Command Parameters](#command-parameters).

##### Usage Scenario

###### Scenario #1: Find groups with the following query - `F12`

1. You can begin this command on any panel.
2. Type and execute: `find_g q/F12`

This screenshot shows the result of executing `find_g q/F12`.

![find_g.png](images/screenshots/find_g.png)

--------------------------------------------------------------------------------------------------------------------

#### Sorting Groups: `sort_g`, `sg`

Explanation of what command does.

**Format**: `sort_g`

##### Notes

1. Are there anything that the command cannot do (e.g. cannot change Student Number) or what does it impact (e.g. will
   remove all students from this deleted group)
2. For information on the constraints for each parameter used in this command, go
   to [Command Parameters](#command-parameters).

##### Usage Scenario (for commands that can be overloaded)

Add more scenarios if necessary

###### Scenario #1

This screenshot shows the result of executing `sort_g`.

--------------------------------------------------------------------------------------------------------------------

### Task Commands

--------------------------------------------------------------------------------------------------------------------

#### Listing Tasks: `list_t`, `lt`

Shows a list of all tasks in the T_Assistant.

**Format**: `list_t [gn/GROUP_NAME]`

##### Notes

1. The group name specified mush exits in T_Assistant.
2. For information on the constraints for each parameter used in this command, go
   to [Command Parameters](#command-parameters).

This screenshot shows the result of executing `list_t`.
![lt.png](images/screenshots/lt.png)

--------------------------------------------------------------------------------------------------------------------

#### Adding a Task to a Group: `add_t_g`, `atg`

Explanation of what command does.

**Format**: `add_t_g tn/TASK_NAME td/TASK_DEADLINE (YYYY-MM-DD HHmm) gn/GROUP_NAME [gn/GROUP_NAME]...`

##### Notes

1. Are there anything that the command cannot do (e.g. cannot change Student Number) or what does it impact (e.g. will
   remove all students from this deleted group)
2. For information on the constraints for each parameter used in this command, go
   to [Command Parameters](#command-parameters).

<box type="warning" seamless>

**Caution:**
The command will stop running the moment it hits an error.

For example `insert your own example`

If the group `CS2103-F12-2` already has the task. The command will only add the task to `CS2103-F11-2` and not
`CS2103-F13-1`.

</box>

##### Usage Scenario (for commands that can be overloaded)

Add more scenarios if necessary

###### Scenario #1

This screenshot shows the result of executing `add_t_g tn/v1.5 Release td/2024-11-07 2359 gn/CS2103-F12-2`.

--------------------------------------------------------------------------------------------------------------------

#### Adding a Task to ALL Groups: `add_t`, `at`

Explanation of what command does.

**Format**: `add_t tn/TASK_NAME td/TASK_DEADLINE (YYYY-MM-DD HHmm)`

##### Notes

1. Are there anything that the command cannot do (e.g. cannot change Student Number) or what does it impact (e.g. will
   remove all students from this deleted group)
2. For information on the constraints for each parameter used in this command, go
   to [Command Parameters](#command-parameters).

<box type="warning" seamless>

**Caution:**
The command will stop running the moment it hits an error.

For example `insert your own example`

If the group `CS2103-F12-2` already has the task. The command will only add the task to `CS2103-F11-2` and not
`CS2103-F13-1`.

</box>

##### Usage Scenario (for commands that can be overloaded)

Add more scenarios if necessary

###### Scenario #1

This screenshot shows the result of executing `add_t tn/Submit Postmortem td/2024-10-20 1800`.

--------------------------------------------------------------------------------------------------------------------

#### Adding an Existing Task to a Group: `add_et_g`, `aetg`

Adds an existing task to the groups specified.

**Format**: `add_et_g i/INDEX gn/GROUP_NAME [gn/GROUP_NAME]...`

##### Notes

1. This command is case-insensitive.
   > `gn/CS2103-F12-2` and `gn/cs2103-f12-2` will be recognised as the same group.
2. You can add an existing task to multiple groups.
3. For information on the constraints for each parameter used in this command, go
   to [Command Parameters](#command-parameters).

<box type="warning" seamless>

**Caution:**
The command will stop running the moment it hits an error.

For example `add_et_g i/1 gn/CS2103-F11-2 gn/CS2103-F12-2 gn/CS2103-F13-1`

If the group `CS2103-F12-2` already has the task. The command will only add the task to `CS2103-F11-2` and not
`CS2103-F13-1`.

</box>

##### Usage Scenario

###### Scenario #1: Add task with index `1` to `CS2103-S1-21`

1. Type and execute: `list_t` to see the list of tasks.
2. After finding the task you wish to add, remember its index number (task with index 1 in this example).
3. You may wish to execute `list_g` to check on the names of groups you wish to add the task to.
4. Type and execute: `add_et_g i/1 gn/CS2103-S1-21`

This screenshot shows the result of executing `add_et_g i/1 gn/CS2103-S1-21`.

![add_existing_task_to_group.png](images/screenshots/add_et_g.png)

###### Scenario #2: Add task that is already in a group

1. Type and execute: `list_t` to see the list of tasks.
2. After finding the task you wish to add, remember its index number (task with index 1 in this example).
3. You may wish to execute `list_g` to check on the names of groups you wish to add the task to.
4. Type and execute: `add_et_g i/1 gn/CS2103-S1-21`
5. You will get an error message.

This screenshot shows the result of executing `add_et_g i/1 gn/CS2103-S1-21`.

![add_existing_task_to_group_err.png](images/screenshots/add_et_g_err.png)

--------------------------------------------------------------------------------------------------------------------

#### Deleting a Task from a Group: `del_t_g`, `dtg`


Deletes a task from a specified group by referencing its index in the group's task list.

**Format**: `del_t_g i/INDEX gn/GROUP_NAME`

##### Notes

1. This command is case-insensitive.
   > `gn/CS2103-F11-2` and `gn/cs2103-f11-2` will be recognised as the same group.
2. The index must be valid and should be the index of target task in the specified group's task list.
3. The group name must exist in T_Assistant.
4. For information on the constraints for each parameter used in this command, go
   to [Command Parameters](#command-parameters).

##### Usage Scenario

###### Scenario #1 Delete task with index `1` from `CS2103-F11-1`
1. Type and execute: `list_t gn/CS2103-F11-1` to see the list of tasks for `CS2103-F11-1`.
2. After finding the task that you wish to delete, remember its index number (task with index 1 in this example).
3. Type and execute: `del_t_g i/1 gn/CS2103-F11-1`

This screenshot shows the result of executing `del_t_g i/1 gn/CS2103-F11-1`.
![dtg.png](images/screenshots/dtg.png)

--------------------------------------------------------------------------------------------------------------------

#### Deleting a Task from ALL Groups: `del_t`, `dt`

Deletes a task from all groups that contain it.

**Format**: `del_t i/INDEX`

##### Notes

1. The index should be the index of target task in the task list.
2. The index mush be valid.
2. For information on the constraints for each parameter used in this command, go
   to [Command Parameters](#command-parameters).

##### Usage Scenario (for commands that can be overloaded)

###### Scenario #1 Delete task with index `2`
1. Type and execute: `list_t` to see the list of tasks.
2. After finding the task that you wish to delete, remember its index number (task with index 2 in this example).
3. Type and execute: `del_t i/2`
This screenshot shows the result of executing `del_t i/2`.
![dt.png](images/screenshots/dt.png)



--------------------------------------------------------------------------------------------------------------------

#### Editing a Task for a Group: `edit_t_g`, `etg`

Edits a task from a specified group by referencing its index in the group's task list.

**Format**: `edit_t_g i/INDEX gn/GROUP_NAME [tn/TASK_NAME] [td/TASK_DEADLINE (YYYY-MM-DD HHmm)`

##### Notes

1. The referenced group name must exits in the T_Assistant.
2. The index must be valid.
3. The input deadline must follow the format: `YYYY-MM-DD HHMM` (e.g., `2024-12-01 2359`)
4. For information on the constraints for each parameter used in this command, go
   to [Command Parameters](#command-parameters).

##### Usage Scenario (for commands that can be overloaded)

###### Scenario #1 Edit task with index `1` in `CS2103-F11-1`
1. Type and execute: `list_t gn/CS2103-F11-1` to see the list of tasks for `CS2103-F11-1`.
2. After finding the task that you wish to delete, remember its index number (task with index 1 in this example).
3. Type and execute: `edit_t_g i/1 gn/CS2103-F11-1 tn/v1.4 Release`
This screenshot shows the result of executing `edit_t_g i/1 gn/CS2103-F11-1 tn/v1.4 Release`.
![etg.png](images/screenshots/etg.png)


--------------------------------------------------------------------------------------------------------------------

#### Editing a Task for ALL Groups: `edit_t`, `et`

Edits a task from all groups that contain it.

**Format**: `edit_t i/INDEX [tn/TASK_NAME] [td/TASK_DEADLINE (YYYY-MM-DD HHmm)`

##### Notes

1. The index mush be valid.
2. The input deadline must follow the format: `YYYY-MM-DD HHMM` (e.g., `2024-12-01 2359`)
2. For information on the constraints for each parameter used in this command, go
   to [Command Parameters](#command-parameters).

##### Usage Scenario

###### Scenario #1 Edit task with index `1`
1. Type and execute: `list_t` to see the list of tasks.
2. After finding the task that you wish to delete, remember its index number (task with index 2 in this example).
3. Type and execute: `edit_t i/2`

This screenshot shows the result of executing `edit_t i/2 tn/PE`.
![et.png](images/screenshots/et.png)

--------------------------------------------------------------------------------------------------------------------

#### Mark a Task for a Group: `mark_t`, `mt`

Explanation of what command does.

**Format**: `mark_t gn/GROUP_NAME i/INDEX`

##### Notes

1. Are there anything that the command cannot do (e.g. cannot change Student Number) or what does it impact (e.g. will
   remove all students from this deleted group)
2. For information on the constraints for each parameter used in this command, go
   to [Command Parameters](#command-parameters).

##### Usage Scenario (for commands that can be overloaded)

Add more scenarios if necessary

###### Scenario #1

This screenshot shows the result of executing `mark_t gn/CS2103-F12-2 i/2`.

--------------------------------------------------------------------------------------------------------------------

#### Finding Tasks: `find_t`, `ft`

Searches T_Assistant for tasks with fields that match the search query.

**Format**: `find_t q/QUERY [q/QUERY]...`

##### Notes

1. This command is case-insensitive.
2. The command will match substrings. You may search for part of a group's name such as `tp` to find `tP v1.6 Release`.
3. Searches the following field that a group has that matches the query:
    * Task name
4. For information on the constraints for each parameter used in this command, go
   to [Command Parameters](#command-parameters).

##### Usage Scenario

###### Scenario #1: Find task with the following query: `consultation`

This screenshot shows the result of executing `find_t q/consulation`.

--------------------------------------------------------------------------------------------------------------------

#### Sorting Tasks: `sort_t`, `st`

Explanation of what command does.

**Format**: `sort_t`

##### Notes

1. Are there anything that the command cannot do (e.g. cannot change Student Number) or what does it impact (e.g. will
   remove all students from this deleted group)
2. For information on the constraints for each parameter used in this command, go
   to [Command Parameters](#command-parameters).

##### Usage Scenario (for commands that can be overloaded)

Add more scenarios if necessary

###### Scenario #1

This screenshot shows the result of executing `sort_t`.

--------------------------------------------------------------------------------------------------------------------

### Miscellaneous Commands

--------------------------------------------------------------------------------------------------------------------

#### Undoing change: `undo`

Undoes the previous command ran.

Format: `undo`

#### Redoing change: `redo`

Redoes the previous command ran.

Format: `redo`

#### Viewing help : `help`

Shows a message explaining how to access the help page.

![help message](images/screenshots/helpMessage.png)

Format: `help`

#### Clearing all entries : `clear`

Clears all entries from the assistant.

Format: `clear`

#### Exiting the program : `exit`

Exits the program.

Format: `exit`

--------------------------------------------------------------------------------------------------------------------

## Data Handling

--------------------------------------------------------------------------------------------------------------------

### Saving the data

T_Assistant data are saved in the hard disk automatically after any command that changes the data. There is no need to
save manually.

### Editing the data file

T_Assistant data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are
welcome to update data directly by editing that data file.

<box type="warning" seamless>

**Caution:**
If your changes to the data file makes its format invalid, T_Assistant will discard all data and start with an empty
data file at the next run. Hence, it is recommended to take a backup of the file before editing it.<br><br>
Furthermore, certain edits can cause the T_Assistant to behave in unexpected ways (e.g., if a value entered is outside
the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</box>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains
the data of your previous T_Assistant home folder and also copy over `versionHistory.json`.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only
   the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the
   application before running the application again.
2. **If you minimize the Help Window** and then run the `help` command (or use the `Help` menu, or the keyboard shortcut
   `F1`) again, the original Help Window will remain minimized, and no new Help Window will appear. The remedy is to
   manually restore the minimized Help Window.
3. The application will sometimes open to a blank screen with no information displayed, simply run any commands and
   the application should function as per normal.

--------------------------------------------------------------------------------------------------------------------

## Glossary

| Key Terms      | Definition                                                   |
|----------------|--------------------------------------------------------------|
| Mainstream OS  | Operating Systems (i.e. Windows, Linux, MacOS                |
| JAR            | Executable file containing Java classes and other resources. |
| Prefix         | Keyword used in commands to specify the parameter type       |
| Student Number | Unique identifier for a student                              |

### Command Parameters

This section will inform you about what parameters are used in T_Assistant and their restrictions :)

<box type="info">
All parameters are case-insensitive when used for comparison unless stated otherwise.
</box>

| Parameter                | Constraints                                                                                                                                                                                                                                                           | <span style="color:green">Correct</span>      | <span style="color:red">Incorrect</span>         |
|--------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------|--------------------------------------------------|
| `sno/`<br>Student Number | Start with `A0`  <br>Followed by 6 numerical digits  <br>End with any letter                                                                                                                                                                                          | `A0123456B`                                   | `A1234567` <br>`A1234567A`                       |
| `sn/`<br>Student Name    | Only contain alphanumeric characters and spaces                                                                                                                                                                                                                       | `John Doe`                                    | `J0hn Doe$$`                                     |
| `e/`<br>Email            | Format: `local-part@domain-part` <br>`local-part` should contain only alphanumeric characters and the following special characters `+`, `_`, `-`, `.` <br>`local-part` must not start and end with any special characters <br>`domain-part` must end with `u.nus.edu` | `johndoe@u.nus.edu` ,<br>`john_doe@u.nus.edu` | `$johndoe@u.nus.edu` <br>`johndoe@gmail.com`     |
| `t/`<br>Tag              | Only contain alphanumeric characters                                                                                                                                                                                                                                  | `TD8`                                         | `TD 8` <br>`Great at UI`                         |
| `gn/`<br>Group Name      | Only contain alphanumeric characters, spaces and `-`                                                                                                                                                                                                                  |                                               |                                                  |
| `tn/`<br>Task Name       | Cannot be blank                                                                                                                                                                                                                                                       | `Release tP v1.6`                             |                                                  |
| `td/`<br>Task Deadline   | Must be in the following format: `YYYY-MM-DD HHmm`<br>Relative to Singapore's timezone                                                                                                                                                                                | `2024-11-09 1800`                             | `today` <br>`2024-1-9 1900` <br>`2024-01-09 800` |
| `q/`<br>Query            | Must contain only 1 word                                                                                                                                                                                                                                              | `iP`<br>`tP`                                  | `Complete iP`                                    |
| `i/`<br>Index            | Must be positive integer                                                                                                                                                                                                                                              | `1`<br>`10`                                   | `-1`<br>`test`                                   |

--------------------------------------------------------------------------------------------------------------------

## Command Summary

### Student

| Action                        | Format, Examples                                                                                                                     |
|-------------------------------|--------------------------------------------------------------------------------------------------------------------------------------|
| **List Students**             | `list_s/ls`                                                                                                                          |
| **Add Student**               | `add_s/as sno/STUDENT_NUMBER sn/STUDENT_NAME e/EMAIL [t/TAG]...`<br>e.g., `as sno/A0123456A sn/James Ho e/e0123456A@u.nus.edu t/TD9` |
| **Delete Student**            | `del_s/ds sno/STUDENT_NUMBER`<br>e.g., `ds sno/A0123456A`                                                                            |
| **Edit Student**              | `edit_s/es sno/STUDENT_NUMBER [sn/STUDENT_NAME] [e/EMAIL] [t/TAG]`<br>e.g., `es sno/A0123456A sn/James Ho Ting Kang`                 |
| **Add Student to Group**      | `add_s_g/asg sno/STUDENT_NUMBER gn/GROUP_NAME`<br>e.g., `asg sno/A0123456A gn/CS2103-F12-2`                                          |
| **Delete Student From Group** | `del_s_g/dsg sno/STUDENT_NUMBER`<br>e.g., `dsg sno/A0123456A`                                                                        |
| **Find Student**              | `find_s/fs q/QUERY [q/QUERY]...`<br>e.g., `fs q/James`                                                                               |
| **Sort Students**             | `sort_s/ss`                                                                                                                          |

### Group

| Action           | Format, Examples                                                                          |
|------------------|-------------------------------------------------------------------------------------------|
| **List Groups**  | `list_g/lg`                                                                               |
| **Add Group**    | `add_g/ag gn/GROUP_NAME [gn/GROUP_NAME]...`<br>e.g., `ag gn/CS2103-F12-2 gn/CS2103-F12-1` |
| **Delete Group** | `del_g/dg gn/GROUP_NAME`<br>e.g., `dg gn/CS2103-F12-2`                                    |
| **Edit Group**   | `edit_g/eg i/INDEX gn/GROUP_NAME`<br>e.g., `eg i/1 gn/CS2103-F12-3`                       |
| **Find Group**   | `find_g/fg q/QUERY [q/QUERY]...`<br>e.g., `fg q/CS2103-F12-2`                             |
| **Sort Groups**  | `sort_g/sg`                                                                               |

### Task

| Action                          | Format, Examples                                                                                                                                                 |
|---------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **List Task**                   | `list_t/lt [gn/GROUP_NAME]`<br>e.g., `lt`, `lt gn/CS2103-F12-2`                                                                                                  |
| **Add Task to Group**           | `add_t_g/atg tn/TASK_NAME td/TASK_DEADLINE (YYYY-MM-DD HHmm) gn/GROUP_NAME [gn/GROUP_NAME]...`<br>e.g., `atg tn/v1.5 Release td/2024-11-07 2359 gn/CS2103-F12-2` |
| **Add Task to All Groups**      | `add_t/at tn/TASK_NAME td/TASK_DEADLINE (YYYY-MM-DD HHmm)`<br>e.g., `at tn/Submit Postmortem td/2024-10-20 1800`                                                 |
| **Add Existing Task to Group**  | `add_et_g/aetg i/INDEX gn/GROUP_NAME [gn/GROUP_NAME]...`<br>e.g., `aetg i/1 gn/CS2103-F12-3`                                                                     |
| **Delete Task from All Groups** | `del_t/dt i/INDEX`<br>e.g., `dt i/1`                                                                                                                             |
| **Delete Task from Group**      | `del_t_g/dtg i/INDEX gn/GROUP_NAME`<br>e.g., `dtg i/1 gn/CS2103-F12-2`                                                                                           |
| **Edit Task for Group**         | `edit_t_g/etg i/INDEX gn/GROUP_NAME [tn/TASK_NAME] [td/TASK_DEADLINE (YYYY-MM-DD HHmm)` <br>e.g., `etg i/1 gn/CS2103-F12-3 tn/v1.4 Release`                      |
| **Edit Task for All Groups**    | `edit_t/et i/INDEX [tn/TASK_NAME] [td/TASK_DEADLINE (YYYY-MM-DD HHmm)`<br>e.g., `et i/1 td/2024-11-20 1200`                                                      |
| **Mark Task**                   | `mark_t/mt gn/GROUP_NAME i/INDEX`<br>e.g., `mt gn/CS2103-F12-2 i/2`                                                                                              |
| **Find Task**                   | `find_t/ft q/QUERY [q/QUERY]...`<br>e.g., `ft q/v1.3 Release`                                                                                                    |
| **Sort Tasks**                  | `sort_t/st`                                                                                                                                                      |

### Misc.

| Action    | Format, Examples |
|-----------|------------------|
| **Help**  | `help`           |
| **Clear** | `clear`          |
| **Undo**  | `undo`           |
| **Redo**  | `redo`           |
| **Exit**  | `exit`           |
