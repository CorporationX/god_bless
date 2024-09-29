INSERT INTO events (id, title, start_date, end_date, owner_id, description, location, max_attendees)
VALUES(1199, 'SuperStar', '2021-01-01 01:00:00'::timestamp, '2024-01-01 01:00:00'::timestamp, 3377, 'Get it!', 'London', 717);

INSERT INTO events (id, title, start_date, end_date, owner_id, description, location, max_attendees)
VALUES(2299, 'SuperStar', '2021-01-01 01:00:00'::timestamp, '2024-01-01 01:00:00'::timestamp, 3377, 'Get it!', 'London', 717);

INSERT INTO skills (id, skill_type)
VALUES(1177, 'strong'),
      (2277, 'high'),
      (3377, 'wizard');

INSERT INTO event_skill (event_id, skill_id)
VALUES (1199, 1177),
       (1199, 2277),
       (1199, 3377),
       (2299, 1177),
       (2299, 1177),
       (2299, 1177);
