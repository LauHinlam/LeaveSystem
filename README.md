# LeaveSystem

Run the program:  
In command line, first use `cd' command to change the path to where the file stored.  
Then run :  
$ java -jar LeaveSystemApplication.jar  

How to use the program:  
Select a node and click 'Add' to add a child node for it. If no node selected, root will be selected.  
Select a node and click 'Remove' to remove this node. Note: root cannot be removed.  
Select a node and click 'Leave' to make a leaving application. The application will be stored into the supervisor's object, and will be handle later. Note: the Director cannot request a leave.  
Select a node and click 'Message' to read unread messages. Messages content includes: predecessor's leaving request, the result of its request (endorsed or declined). For predecessor's request, can either endorse or decline.  
