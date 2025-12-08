drop table if exists tb_pallet cascade
drop table if exists tb_product cascade

create table tb_pallet (
        boxes integer,
        days integer,
        code bigint,
        code_note bigint,
        id bigint not null,
        chamber varchar(255),
        position varchar(255),
        road varchar(255),
        primary key (id)
    )

create table tb_product (
    days integer,
    net_weight_box float(53),
    packets smallint,
    production date,
    validity date,
    code bigint,
    code_note bigint,
    id bigint not null,
    pallet_fk bigint NULL,
    primary key (id)
)

alter table if exists tb_product
   add constraint FK3l7ohynmpl643dgrvjqqk53st
   foreign key (pallet_fk) NULL
   references tb_pallet