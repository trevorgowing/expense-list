CREATE TABLE IF NOT EXISTS users (
  id                      BIGINT(20)   NOT NULL AUTO_INCREMENT,
  db_date_created         TIMESTAMP             DEFAULT CURRENT_TIMESTAMP(),
  db_date_updated         TIMESTAMP    NULL     ON UPDATE CURRENT_TIMESTAMP(),
  app_created_date        DATETIME              DEFAULT NULL,
  app_created_by_id       BIGINT(20)            DEFAULT NULL,
  app_last_modified_date  DATETIME              DEFAULT NULL,
  app_last_modified_by_id BIGINT(20)            DEFAULT NULL,
  email                   VARCHAR(255) NOT NULL,
  first_name              VARCHAR(255)          DEFAULT NULL,
  last_name               VARCHAR(255)          DEFAULT NULL,
  password                VARCHAR(255) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY users_email_unique_key (email),
  KEY users_created_by_id_foreign_key (app_created_by_id),
  CONSTRAINT users_created_by_id_constraint FOREIGN KEY (app_created_by_id) REFERENCES users (id),
  KEY users_last_modified_by_id_foreign_key (app_last_modified_by_id),
  CONSTRAINT users_last_modified_by_id_constraint FOREIGN KEY (app_last_modified_by_id) REFERENCES users (id)
) ENGINE = InnoDB DEFAULT CHARSET = latin1;

CREATE TABLE IF NOT EXISTS expenses (
  id                      BIGINT(20)      NOT NULL  AUTO_INCREMENT,
  db_date_created         TIMESTAMP                 DEFAULT CURRENT_TIMESTAMP(),
  db_date_updated         TIMESTAMP       NULL      ON   UPDATE CURRENT_TIMESTAMP(),
  app_created_date        DATETIME                  DEFAULT NULL,
  app_created_by_id       BIGINT(20)                DEFAULT NULL,
  app_last_modified_date  DATETIME                  DEFAULT NULL,
  app_last_modified_by_id BIGINT(20)                DEFAULT NULL,
  user_id                 BIGINT(20)      NOT NULL,
  date                    DATETIME        NOT NULL,
  value                   DECIMAL(13, 2)  NOT NULL,
  reason                  TEXT                      DEFAULT NULL,
  PRIMARY KEY (id),
  KEY expenses_created_by_id_foreign_key (app_created_by_id),
  CONSTRAINT expenses_created_by_id_constraint FOREIGN KEY (app_created_by_id) REFERENCES users (id),
  KEY expenses_last_modified_by_id_foreign_key (app_last_modified_by_id),
  CONSTRAINT expenses_last_modified_by_id_constraint FOREIGN KEY (app_last_modified_by_id) REFERENCES users (id),
  KEY expenses_user_id_foreign_key (user_id),
  CONSTRAINT expenses_user_id_constraint FOREIGN KEY (user_id) REFERENCES users (id)
) ENGINE = InnoDB DEFAULT CHARSET = latin1;