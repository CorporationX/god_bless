INSERT INTO members(id, name, gender, email, location, age, last_date, role)
VALUES (789111, 'Hercules', true, 'geracl@gmail.com', 'Greece', 3333, CURRENT_TIMESTAMP,  'ROLE_OWNER'),
       (789222, 'Athena', false, 'afina@gmail.com', 'Rome', 17, CURRENT_TIMESTAMP, 'ROLE_FAKE'),
       (789333, 'Dionysius', true, 'dionysius@greece.com', 'Athens', 9999, CURRENT_TIMESTAMP, 'ROLE_USER'),
       (789777, 'Aphrodite', false, 'aphrodite@antient.om', 'Naples', 21, CURRENT_TIMESTAMP, 'ROLE_TEAMLEAD');

INSERT INTO phones(id, phone, member_id)
VALUES(1001, 123123, 789111),
      (1002, 321321, 789111),
      (1003, 765567, 789222),
      (1004, 322223, 789333),
      (1005, 223322, 789333),
      (1007, 777771, 789777);

