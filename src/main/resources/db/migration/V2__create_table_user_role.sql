CREATE TABLE role(
	id BIGINT(20) NOT NULL,
	role VARCHAR(50) NOT NULL,
	PRIMARY KEY (id)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_role (
	user_id BIGINT(20) NOT NULL,
	role_id BIGINT(20) NOT NULL,
	PRIMARY KEY (user_id, role_id),
	FOREIGN KEY (user_id) REFERENCES user(id),
	FOREIGN KEY (role_id) REFERENCES role(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO role (id, role) VALUES (1, 'WRITER');
INSERT INTO role (id, role) VALUES (2, 'READER');