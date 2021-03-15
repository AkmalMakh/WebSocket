# REST endpoints
## USER: 
Post  api/users/ — create new user
Get   api/users/  — read list of users
Get   api/users/{userID} — read single user
PUT  api/users/   — Update Exciting user
Delete api/users/{userID} — delete exciting user

## USER’s Friend: 
Post  api/users/{usersId}/contacts — create new user’s contact
Get  api/users/{usersId}/contacts  — read list of user’s  contacts
Get api/users/contacts/{contactId} — read single user’s contact
Delete api/users/{usersId}/contact — delete exciting user’s contact by id


## USER’s Chat Room:
Post  api/users/{userId}/chatrooms — create  user’s new chat room
Get  api/users/userId/chatrooms/  — read list of user’s chat rooms
Get api/users/chatrooms/{chatroomId} — read single user’s chat room
Delete api/users/{userId}/chatrooms/{chatroomId} — delete exciting user’s chatRoom
 

## User’s chat room’s messages
Post  api/chatrooms/{chatroomsId}/messages — create  user’s new chat room
Get  api/chatrooms/{chatroomsId}/messages — get  user’s  chat room’s list of messages
Delete api/chatroom/{chatroomId}/messages/{messageId} — deletes specific message


