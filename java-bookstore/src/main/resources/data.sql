-- INSERT INTO section, name) VALUES (1, 'Fiction');
-- INSERT INTO section, name) VALUES (2, 'Technology');
-- INSERT INTO section, name) VALUES (3, 'Travel');
-- INSERT INTO section, name) VALUES (4, 'Business');
-- INSERT INTO section, name) VALUES (5, 'Religion');

INSERT INTO authors (authorid, firstname, lastname) VALUES (1, 'John', 'Mitchell');
INSERT INTO authors (authorid, firstname, lastname) VALUES (2, 'Dan', 'Brown');
INSERT INTO authors (authorid, firstname, lastname) VALUES (3, 'Jerry', 'Poe');
INSERT INTO authors (authorid, firstname, lastname) VALUES (4, 'Wells', 'Teague');
INSERT INTO authors (authorid, firstname, lastname) VALUES (5, 'George', 'Gallinger');
INSERT INTO authors (authorid, firstname, lastname) VALUES (6, 'Ian', 'Stewart');

INSERT INTO book (bookid, booktitle, ISBN) VALUES (1, 'Flatterland', '9780738206752');
INSERT INTO book (bookid, booktitle, ISBN) VALUES (2, 'Digital Fortess', '9788489367012');
INSERT INTO book (bookid, booktitle, ISBN) VALUES (3, 'The Da Vinci Code', '9780307474278');
INSERT INTO book (bookid, booktitle, ISBN) VALUES (4, 'Essentials of Finance', '1314241651234');
INSERT INTO book (bookid, booktitle, ISBN) VALUES (5, 'Calling Texas Home', '1885171382134');

-- INSERT INTO wrote (bookid, authorid) VALUES (1, 6);
-- INSERT INTO wrote (bookid, authorid) VALUES (2, 2);
-- INSERT INTO wrote (bookid, authorid) VALUES (3, 2);
-- INSERT INTO wrote (bookid, authorid) VALUES (4, 5);
-- INSERT INTO wrote (bookid, authorid) VALUES (4, 3);
-- INSERT INTO wrote (bookid, authorid) VALUES (5, 4);

alter sequence hibernate_sequence restart with 25;
