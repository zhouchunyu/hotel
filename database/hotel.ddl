create schema hotel collate utf8_general_ci;

create table hotel
(
	id int auto_increment
		primary key,
	businessDistrict varchar(100) null,
	introduction longtext null,
	services_and_facilities longtext null,
	starRating varchar(10) null,
	src text null,
	address text null
);

create table room_type
(
	id int auto_increment
		primary key,
	type varchar(50) null,
	num int null,
	price double null,
	hotel_id int null,
	src text null,
	constraint room_type_hotel__fk
		foreign key (hotel_id) references hotel (id)
);

create table users
(
	nickname varchar(40) null,
	username varchar(50) not null
		primary key,
	password varchar(500) not null,
	phone varchar(20) null,
	enabled tinyint(1) not null
);

create table authorities
(
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint ix_auth_username
		unique (username, authority),
	constraint fk_authorities_users
		foreign key (username) references users (username)
);

create table orders
(
	id int auto_increment
		primary key,
	checkInTime datetime null,
	checkoutTime datetime null,
	roomTypeId int null,
	roomsCount int null,
	peopleCount int null,
	withOrWithoutChildren tinyint null,
	hotelId int null,
	username varchar(50) null,
	constraint order_hotel__fk
		foreign key (hotelId) references hotel (id),
	constraint order_room_type__fk
		foreign key (roomTypeId) references room_type (id),
	constraint orders_user__fk
		foreign key (username) references users (username)
);

