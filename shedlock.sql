CREATE TABLE shedlock
(
    name       VARCHAR(64),
    lock_until TIMESTAMP NULL,
    locked_at  TIMESTAMP NULL,
    locked_by  VARCHAR(255),
    PRIMARY KEY (name)
);