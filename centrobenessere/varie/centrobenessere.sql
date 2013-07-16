
    create table Prenotazione (
        id int8 not null,
        dataPrenotazione timestamp,
        utente_id int8,
        prestazione_id int8,
        primary key (id)
    );

    create table Prestazione (
        id int8 not null,
        costo float8,
        tipo varchar(255),
        prenotazione_id int8,
        primary key (id)
    );

    create table Utente (
        id int8 not null,
        codiceFiscale varchar(255),
        cognome varchar(255),
        nome varchar(255),
        sesso varchar(255),
        primary key (id)
    );

    alter table Prenotazione 
        add constraint FK7B209A86B2736D58 
        foreign key (utente_id) 
        references Utente;

    alter table Prenotazione 
        add constraint FK7B209A8691127FC 
        foreign key (prestazione_id) 
        references Prestazione;

    alter table Prestazione 
        add constraint FK1E14BA3A324B93B8 
        foreign key (prenotazione_id) 
        references Prenotazione;

    create sequence hibernate_sequence;
