CREATE TABLE account
(
    id uuid NOT NULL,
    "number" character varying(10) NOT NULL,
    type character varying(70) NOT NULL,
    creation_date timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    CONSTRAINT unique_account UNIQUE ("number")
);

CREATE TABLE transaction
(
    id uuid NOT NULL,
    amount double precision NOT NULL,
    type smallint NOT NULL,
    creation_date timestamp with time zone NOT NULL DEFAULT CURRENT_TIMESTAMP,
    account_id uuid,
    comment character varying(120) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT account_fk FOREIGN KEY (account_id)
        REFERENCES account (id)
);