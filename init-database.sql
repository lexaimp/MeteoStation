DROP TABLE IF EXISTS "weather";

CREATE TABLE "public"."weather" (
    "id" bigint GENERATED ALWAYS AS IDENTITY (INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1) ,
    "date" timestamp NOT NULL,
    "air_temperature" real,
    "humidity" real,
    "source_id" bigint,
    CONSTRAINT "weather_pkey" PRIMARY KEY ("id")
) WITH (oids = false);

DROP TABLE IF EXISTS "weather_source";

CREATE TABLE "public"."weather_source" (
    "id" bigint GENERATED ALWAYS AS IDENTITY (INCREMENT 1 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1) ,
    "name" character varying(255),
    "mac_address" character(17),
    "comment" character varying,
    CONSTRAINT "weather_source_pkey" PRIMARY KEY ("id")
) WITH (oids = false);


ALTER TABLE ONLY "public"."weather" ADD CONSTRAINT "weather_source_id_fkey" FOREIGN KEY (source_id) REFERENCES weather_source(id) NOT DEFERRABLE;