create table CHAT_MESSAGE (
	MESSAGE_ID    INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	NICKNAME      VARCHAR(20) NOT NULL,
	REGISTER_DATE DATETIME NOT NULL,
	MESSAGE       VARCHAR(200) NOT NULL
)