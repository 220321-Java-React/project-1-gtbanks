------------project1 AWS

create table ers_reimbursement(
	reimb_id serial primary key,
	reimb_amount int,
	reimb_submitted timestamp,
	user_id_fk int references ers_user (user_id),
	reimb_status_id_fk int references reimbursement_status (reimb_status_id),
	reimb_type_id_fk int references reimbursement_type (reimb_type_id)
);
----Workiking ers_reimbursement
create table ers_reimbursement(
	reimb_id serial primary key,
	reimb_type text not null,
	reimb_amount int not null,
	reimb_author_id int,
	reimb_resolver_id int,
	reimb_submitted timestamp not null,
	user_id_fk int references ers_user (user_id),
	reimb_status_id_fk int references reimbursement_status (reimb_status_id),
	reimb_type_id_fk int references reimbursement_type (reimb_type_id)	
);
create table ers_reimbursement(
	reimb_id serial primary key,
	reimb_type text,
	reimb_amount int,
	reimb_submitted timestamp,
	reimb_author_id_fk int references ers_user (ers_user_id),
	reimb_status_id_fk int references reimbursement_status (reimb_status_id),
	reimb_type_id_fk int references reimbursement_type (reimb_type_id)	
);






insert into ers_reimbursements(reimb_submitted)
VALUES (current_timestamp);

set current_timestamp
where reimb_submitted =   );

set to_timestamp() 

drop table ers_reimbursement; 
	pending
insert into ers_reimbursements (reimb_id, reimb_type, reimb_amount, reimb_submitted, reimb_author_id_fk, reimb_status_id_fk)
values (default, 'Lodging', 300, default, default, 1),
       (default, 'Travel', 175, default, default, 2),
       (default, 'Travel', 894, default, default, 2),
       (default, 'Food', 320, default, default, 3),
       (default, 'Other', 550, default, default, 2);
--------working

alter ers_reimbursement 
	set "column1"  = '2'
	where "joint" = ' ';
      
create table ers_users(
	user_id serial primary key,
	username text(5) unique not null,
	"password" text(5) unique not null,
	f_name text(10) not null,
	l_name text(10) not null,
	email text(10) not null,
	user_role_id_fk int references user_role (user_role_id) 
);
--------working ers users
create table ers_user(
	user_id serial primary key,
	username text unique not null,
	"password" text unique not null,
	f_name text not null,
	l_name text not null,
	email text not null,
	user_role_id_fk int references user_role (user_role_id) 
);

insert into ers_user (user_id, username, "password", f_name, l_name, email, user_role_id_fk)
values (default, 'sbriggs', 'sherri', 'Sherri', 'Briggs', 'sbriggs@rev.net', default),
	   (default, 'kbanks', 'ken', 'Ken', 'Banks', 'kbanx@rev.net', default),
	   (default, 'elamb', 'eric', 'Eric', 'Lamb', 'elamb@rev.net', default),
	   (default, 'ewhite', 'eryka', 'Eryka', 'White', 'ewhite@rev.net', default),
	   (default, 'devans','don', 'Don', 'Evans', 'devans@rev.net', default); 
alter table if exists ers_users
rename to ers_user;

create table reimbursement_status(
	reimb_status_id serial primary key,
	reimb_status text
);

insert into reimbursement_status (reimb_status_id, reimb_status)
values (default, 'Approved'),
	   (default, 'Pending'),
	   (default, 'Denied');

	  
update reimbursement_status
set reimb_status = 'Pending'
where reimb_status_id = 1;

	  
create table reimbursement_type(
	reimb_type_id serial primary key,
	reimb_type text
);

insert into reimbursement_type (reimb_type_id, reimb_type)
values (default, 'Travel'),
	   (default, 'Lodging'),
	   (default, 'Food'),
	   (default, 'Other');
	   
	
create table user_role(
	user_role_id serial primary key,
	user_role text 
);

insert into user_role (user_role_id, user_role)
values (default, 'Manager'),
	   (default, 'IT'),
	   (default, 'Executive Assistant'),
	   (default, 'Driver'),
	   (default, 'Accountant');
	  
---------Project one AWS