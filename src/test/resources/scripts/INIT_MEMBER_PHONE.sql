INSERT INTO members(id, name, gender, email, location, age, last_date, role)
VALUES (987111, 'Hermes', true, 'hermes@gmail.com', 'Greece', 3333, CURRENT_TIMESTAMP, 'ROLE_USER'),
       (987222, 'Flora', false, 'flora@gmail.com', 'Rome', 17, CURRENT_TIMESTAMP, 'ROLE_FAKE'),
       (987333, 'Zeus', true, 'zeus@greece.com', 'Athens', 9999, CURRENT_TIMESTAMP, 'ROLE_OWNER'),
       (987777, 'Hera', false, 'hera@antient.om', 'Naples', 21, CURRENT_TIMESTAMP, 'ROLE_TEAMLEAD');

INSERT INTO phones(id, phone, member_id)
VALUES(10311, 123123321, 987111),
      (10322, 321321321, 987111),
      (10333, 765567765, 987222),
      (10344, 322223323, 987333),
      (10355, 223322223, 987333),
      (10377, 177771177, 987777);

