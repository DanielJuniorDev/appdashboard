CREATE TABLE aplication (
    id      int(10)         UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(100)    NOT NULL,
    url     VARCHAR(255)    NOT NULL,
    active  BOOLEAN         NOT NULL,
    picture VARCHAR(255)
)