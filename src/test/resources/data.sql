INSERT INTO role (id, type) VALUES (1,'user'), (2, 'admin');
INSERT INTO `user` (is_enabled, role_id, city, username, email, password, zip_code) VALUES (true, 1, 'Bordeaux', 'cookie', 'cookie@mail.com', '$2a$10$FBoikvUuOadg23lRYVfPseY/rLHGQAtZWz69suOQ2FEI829DRArbW', 56000);
INSERT INTO category (id, category) VALUES (1, 'Bandes dessinées'), (2, 'Cuisine'), (3, 'Histoire');
