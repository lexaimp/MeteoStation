DROP TABLE IF EXISTS "weather";
DROP SEQUENCE IF EXISTS weather_id_seq;
CREATE SEQUENCE weather_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "public"."weather" (
    "id" bigint DEFAULT nextval('weather_id_seq') NOT NULL,
    "date" timestamp NOT NULL,
    "air_temperature" real,
    "humidity" smallint,
    "source_id" bigint,
    CONSTRAINT "weather_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


DROP TABLE IF EXISTS "weather_source";
DROP SEQUENCE IF EXISTS weather_source_id_seq;
CREATE SEQUENCE weather_source_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

CREATE TABLE "public"."weather_source" (
    "id" bigint DEFAULT nextval('weather_source_id_seq') NOT NULL,
    "name" character varying(255),
    "comment" character varying,
    CONSTRAINT "weather_source_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


ALTER TABLE ONLY "public"."weather" ADD CONSTRAINT "weather_source_id_fkey" FOREIGN KEY (source_id) REFERENCES weather_source(id) NOT DEFERRABLE;