/* 
 * Created by Khoa Le on 2017.12.05  * 
 * Copyright © 2017 Khoa Le. All rights reserved. * 
 */
/**
 * Author:  khoal
 * Created: Dec 5, 2017
 */
CREATE TABLE AccountData
(
    id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT NOT NULL,
    user_id INT UNSIGNED,
    title VARCHAR (256) NOT NULL,
    dataset VARCHAR (512) NOT NULL,
    race_filter VARCHAR (256) NOT NULL,
    sex_filter VARCHAR (256) NOT NULL,
    min_year VARCHAR (4) NOT NULL,
    max_year VARCHAR (4) NOT NULL,
    graph_type VARCHAR (256) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE CASCADE
);

