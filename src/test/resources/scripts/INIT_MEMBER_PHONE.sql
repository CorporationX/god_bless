INSERT INTO users(id, username, gender, email, location, age, last_date, role, password)
VALUES (987111, 'Hercules', true, 'geracl@gmail.com', 'Greece', 3333, CURRENT_TIMESTAMP, 'ROLE_ADMIN', 'pass1'),
       (987222, 'Athena', false, 'afina@gmail.com', 'Rome', 17, CURRENT_TIMESTAMP, 'ROLE_ADMIN', 'pass2'),
       (987333, 'Dionysius', true, 'dionysius@greece.com', 'Athens', 9999, CURRENT_TIMESTAMP, 'ROLE_STAFF', 'pass3'),
       (987777, 'Aphrodite', false, 'aphrodite@antient.om', 'Naples', 21, CURRENT_TIMESTAMP, 'ROLE_USER', 'pass4');

INSERT INTO phones(id, phone, user_id)
VALUES(11, 123123, 987111),
      (22, 321321, 987111),
      (33, 765567, 987222),
      (44, 322223, 987333),
      (55, 223322, 987333),
      (77, 777771, 987777);


