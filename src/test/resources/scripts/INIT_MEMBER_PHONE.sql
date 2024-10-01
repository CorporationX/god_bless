INSERT INTO members(id, name, gender, email, location, age, last_date, role)
VALUES (111, 'Hercules', true, 'geracl@gmail.com', 'Greece', 3333, CURRENT_TIMESTAMP, 'ROLE_ADMIN'),
       (222, 'Athena', false, 'afina@gmail.com', 'Rome', 17, CURRENT_TIMESTAMP, 'ROLE_ADMIN'),
       (333, 'Dionysius', true, 'dionysius@greece.com', 'Athens', 9999, CURRENT_TIMESTAMP, 'ROLE_STAFF'),
       (777, 'Aphrodite', false, 'aphrodite@antient.om', 'Naples', 21, CURRENT_TIMESTAMP, 'ROLE_USER');


INSERT INTO phones(id, phone, member_id)
VALUES(11, 123123, 111),
      (22, 321321, 111),
      (33, 765567, 222),
      (44, 322223, 333),
      (55, 223322, 333);


