INSERT INTO event (id, title, start_date, end_date, owner_id, description, location, max_attendees)
VALUES(111, 'SuperStar', '2021-01-01 01:00:00'::timestamp, '2024-01-01 01:00:00'::timestamp, 33, 'Get it!', 'London', 717);

INSERT INTO event (id, title, start_date, end_date, owner_id, description, location, max_attendees)
VALUES(222, 'SuperStar', '2021-01-01 01:00:00'::timestamp, '2024-01-01 01:00:00'::timestamp, 33, 'Get it!', 'London', 717);

INSERT INTO skill (id, skill_type)
VALUES(11, 'strong'),
      (22, 'high'),
      (33, 'wizard');

INSERT INTO event_skill (event_id, skill_id)
VALUES (111, 11),
       (111, 22),
       (111, 33);
