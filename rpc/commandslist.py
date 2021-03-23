# import requests to make our lives easier
import requests
# import socket to do IP address checks
import util
# import commands
import commands
import cmd_node

# registers all commands to the command manager
def register_all(cmdManager):
    # this command sets the node ip and port
    cmdManager.register('setnode', cmd_node.parse)
    # this command exists the rpc client but does not affect the server
    cmdManager.register('quit', cmd_quit.parse)