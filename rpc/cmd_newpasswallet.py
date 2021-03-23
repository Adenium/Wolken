# import commands
import commands
# password helper
from getpass import getpass


# define 'createwallet' command
def parse(cmd, arguments, connection):
    if len(arguments) != 2:
        print("error: '"+cmd.name+"' requires one argument.")
    else:
        name    = arguments[1]

        response = connection.send_request('dumpwallet', {'name':name})
        print("alert: server responded with '"+response.response+"'.")
        if response.response == 'failed':
            print("reason: " + response.reason)

