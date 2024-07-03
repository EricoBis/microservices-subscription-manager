INSERT INTO client (client_id, email, name) VALUES (1, 'Albert Newby', 'albert.newby@gmail.com');
INSERT INTO client (client_id, email, name) VALUES (2, 'Angela Gonzalez', 'angela.gonzalez@gmail.com');
INSERT INTO client (client_id, email, name) VALUES (3, 'Edward Eggleston', 'edward.eggleston@gmail.com');
INSERT INTO client (client_id, email, name) VALUES (4, 'Kenneth Schmid', 'kenneth.schmid@gmail.com');
INSERT INTO client (client_id, email, name) VALUES (5, 'Mary Tanner', 'mary.tanner@gmail.com');
INSERT INTO client (client_id, email, name) VALUES (6, 'John Jordan', 'john.jordan@gmail.com');
INSERT INTO client (client_id, email, name) VALUES (7, 'Stephen Brown', 'stephen.brown@gmail.com');
INSERT INTO client (client_id, email, name) VALUES (8, 'Steve Hinton', 'steve.hinton@gmail.com');
INSERT INTO client (client_id, email, name) VALUES (9, 'Roberto Ross', 'roberto.ross@gmail.com');
INSERT INTO client (client_id, email, name) VALUES (10, 'John Blair', 'john.blair@gmail.com');

INSERT INTO application (app_id, name, cost) VALUES (1, 'Flixify', 15.90);
INSERT INTO application (app_id, name, cost) VALUES (2, 'Streampulse', 9.50);
INSERT INTO application (app_id, name, cost) VALUES (3, 'Vidpop', 19.99);
INSERT INTO application (app_id, name, cost) VALUES (4, 'Rhythmix', 10.25);
INSERT INTO application (app_id, name, cost) VALUES (5, 'Groovify', 13.90);

INSERT INTO subscription (subscription_id, client_id, application_id, begin_subscription, end_subscription) VALUES (1000, 1, 1, TO_DATE('03/07/2024', 'dd/mm/yyyy'), TO_DATE('03/08/2024', 'dd/mm/yyyy'));
INSERT INTO subscription (subscription_id, client_id, application_id, begin_subscription, end_subscription) VALUES (1001, 2, 1, TO_DATE('20/05/2024', 'dd/mm/yyyy'), TO_DATE('20/06/2024', 'dd/mm/yyyy'));
INSERT INTO subscription (subscription_id, client_id, application_id, begin_subscription, end_subscription) VALUES (1002, 3, 3, TO_DATE('01/07/2024', 'dd/mm/yyyy'), TO_DATE('01/08/2024', 'dd/mm/yyyy'));
INSERT INTO subscription (subscription_id, client_id, application_id, begin_subscription, end_subscription) VALUES (1003, 8, 4, TO_DATE('15/05/2024', 'dd/mm/yyyy'), TO_DATE('15/06/2024', 'dd/mm/yyyy'));
INSERT INTO subscription (subscription_id, client_id, application_id, begin_subscription, end_subscription) VALUES (1004, 6, 3, TO_DATE('27/04/2024', 'dd/mm/yyyy'), TO_DATE('27/05/2024', 'dd/mm/yyyy'));
