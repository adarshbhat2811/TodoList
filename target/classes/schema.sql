DROP TABLE User IF EXISTS;

CREATE TABLE User (
	user_id int primary key identity,
    username varchar(50) unique not null,
    password varchar(30) not null
);

DROP TABLE Tasks IF EXISTS;

CREATE TABLE Tasks (
	task_id int primary key identity,
    title varchar(50) not null,
    description varchar(100),
    due_date date not null,
    lastModified date ,
    completed bit not null,
    user_id int foreign key references User(user_id)
        
);


