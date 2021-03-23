# import commands
import commands


# define 'node' command
def parse(command, arguments, connection):
    if len(arguments) != 3:
        print("error: '%s' requires two arguments.", command.name)
    else:
        if not util.is_valid_ip(arguments[1]):
            print("error: 'node' requires the first argument to be a valid IP address.")
            pass
        if not arguments[2].isnumeric():
            print("error: 'node' requires the second argument to be a valid port.")
            pass
        global ip
        global port
        ip      = arguments[1]
        port    = arguments[2]

        print("alert: node connection data set to ('"+arguments[1]+":"+arguments[2]+"')")

