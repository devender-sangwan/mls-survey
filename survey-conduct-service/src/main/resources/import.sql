

-- Create 2 surveys

insert into survey (id, name, published, created_at) values (1, 'Survey-1', true, now());
insert into survey (id, name, published, created_at) values (2, 'Survey-2', true, now());

insert into question (id, survey_id, label, is_deleted, created_at) values (1, 1, 'What is your gender?', true, now());

insert into option (id, question_id, label, is_deleted, created_at) values (1, 1, 'Male', true, now());
insert into option (id, question_id, label, is_deleted, created_at) values (2, 1, 'Female', true, now());
insert into option (id, question_id, label, is_deleted, created_at) values (3, 1, 'Other', true, now());

insert into question (id, survey_id, label, is_deleted, created_at) values (2, 1, 'What is your city?', true, now());

insert into option (id, question_id, label, is_deleted, created_at) values (4, 2, 'Frankfurt', true, now());
insert into option (id, question_id, label, is_deleted, created_at) values (5, 2, 'Munich', true, now());
insert into option (id, question_id, label, is_deleted, created_at) values (6, 2, 'Gateway Garden', true, now());

insert into question (id, survey_id, label, is_deleted, created_at) values (3, 2, 'What is the capital of Germany?', true, now());

insert into option (id, question_id, label, is_deleted, created_at) values (7, 3, 'Berlin', true, now());
insert into option (id, question_id, label, is_deleted, created_at) values (8, 3, 'Munich', true, now());
insert into option (id, question_id, label, is_deleted, created_at) values (9, 3, 'Hamburg', true, now());
insert into option (id, question_id, label, is_deleted, created_at) values (10, 3, 'Stuttgart', true, now());

insert into question (id, survey_id, label, is_deleted, created_at) values (4, 2, 'What is the capital of Hessen State?', true, now());

insert into option (id, question_id, label, is_deleted, created_at) values (11, 4, 'Wiesbaden', true, now());
insert into option (id, question_id, label, is_deleted, created_at) values (12, 4, 'Frankfurt am Main', true, now());
insert into option (id, question_id, label, is_deleted, created_at) values (13, 4, 'Kassel', true, now());
insert into option (id, question_id, label, is_deleted, created_at) values (14, 4, 'Darmstadt', true, now());






