CREATE TABLE IF NOT EXISTS "livestock_commodity"
(
    "id"                        SERIAL UNIQUE PRIMARY KEY NOT NULL,
    
    "age"                       integer, --age in months
    "current_milking_quantity"  integer                     DEFAULT 0,
    "milking_capacity"          integer                     DEFAULT 0,
    "pregnancy_duration"        integer                     DEFAULT 0,
    "number_of_times_calved"    integer                     DEFAULT 0,
    "lactating_for"             integer                     DEFAULT 0,
    "last_impregnated_on"       integer , --TODO: fix this value or name
    "last_calved_on"            integer , -- TODO fix this value or name
    --"created_on"                timestamp                  NOT NULL,
    "name"                      varchar(100)
);