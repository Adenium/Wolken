# import requests to make our lives easier
import requests

# valid commands
# getblock      <hash>
# gettx         <hash>
# getbalance    <address>
# quit

commands = [ new_command('getblock', prase_getblock ]

class Command:
    pass

def base16_encoded(text):
    for c in text.lower():
        if c 
def prase_getblock(command, arguments):
    # check correct amount of arguments exists
    if len(arguments < 2):
        print("error: 'getblock' command requires a minimum of two arguments.")
        pass

    # check that 

def new_command(name, value, parse):
    command = Command()
    command.name    = name
    command.value   = value
    command.parse   = parse
    return command

def scan_commands():
    # get inputs from the command line
    text        = input(">")
    # this shouldn't happen
    if not text:
        return lambda x : None
    # parse the command
    arguments   = text.split(" ")
    # check the length
    if len(arguments) > 0:
        # test against known commands
        for command in commands_list:
            if command.name == arguments[0]:
                return command.parse(arguments)
def start():
    # enter an infinite loop
    while (True):
        # scan the command line for commands
        commands = scan_commands()