create table if not exists domicilio(
id int primary key,
calle varchar(255),
numero varchar(255),
localidad varchar(255),
provincia varchar(255)
);

create table if not exists pacientes
(
    id           int primary key,
    apellido     varchar(255),
    nombre       varchar(255),
    dni          varchar(255),
    ingreso      date,
    domicilio_id int,
    foreign key (domicilio_id) references domicilio (id)
);