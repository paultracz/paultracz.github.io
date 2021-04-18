INSERT INTO equipment (name, price, quantity) VALUES ('Lawn Mower', '129.99', '12');
INSERT INTO equipment (name, price, quantity) VALUES ('Talet Chlorinator', '16.99', '15');
INSERT INTO equipment (name, price, quantity) VALUES ('Feeder', '18.99', '12');
INSERT INTO equipment (name, price, quantity) VALUES ('Floater', '24.99', '80');
INSERT INTO equipment (name, price, quantity) VALUES ('Salt', '8.99', '120');
INSERT INTO equipment (name, price, quantity) VALUES ('Pump', '89.99', '21');
INSERT INTO equipment (name, price, quantity) VALUES ('Filter', '109.99', '32');
INSERT INTO equipment (name, price, quantity) VALUES ('UV Light', '59.99', '41');
INSERT INTO equipment (name, price, quantity) VALUES ('Heater', '249.99', '38');
INSERT INTO equipment (name, price, quantity) VALUES ('Speakers', '139.99', '9');


insert into User (username, encryptedpassword, enabled)
values ('Jon', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
 
insert into User (username, encryptedpassword, enabled)
values ('Tod', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);

insert into User (username, encryptedpassword, enabled)
values ('Admin', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);


insert into Role (rolename)
values ('ROLE_BOSS');

insert into Role (rolename)
values ('ROLE_WORKER');

--insert into Role (rolename)
--values ('ROLE_EMPLOYEE');


insert into user_roles (users_id, roles_id)
values (1, 1);
 
insert into user_roles (users_id, roles_id)
values (2, 2);

insert into user_roles (users_id, roles_id)
values (3, 1);

insert into user_roles (users_id, roles_id)
values (3, 2);


INSERT INTO store (name) VALUES ('Pooly Pools 1');
INSERT INTO store (name) VALUES ('Pooly Pools 2');
