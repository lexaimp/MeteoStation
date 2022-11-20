DROP TABLE IF EXISTS weather_source;
DROP TABLE IF EXISTS weather;

CREATE TABLE weather_source
(
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(255),
    comment VARCHAR
);

CREATE TABLE weather
(
    id                  SERIAL PRIMARY KEY,
    date                TIMESTAMP NOT NULL,
    air_temperature     REAL,
    humidity            SMALLINT,
    sourceId            INTEGER,
    FOREIGN KEY (sourceId) REFERENCES weather_source (id)
);
