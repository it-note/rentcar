-- client 
INSERT INTO `client`(id, password, name, phone, zonecode, address, sub_address) VALUES('imapple', 'vvyQy5y1R2mVGnZgoR0cQQ==', '김사과', '010-1234-1234', '00001', '서울시 강남구', '1');
INSERT INTO `client`(id, password, name, phone, zonecode, address, sub_address) VALUES('banana', 'Y9Rb1Jw4mJSLCpz8MyNz7g==', '김바나', '010-1234-2345', '00001', '서울시 강남구', '1');
INSERT INTO `client`(id, password, name, phone, zonecode, address, sub_address) VALUES('cherry', 'Y9Rb1Jw4mJSLCpz8MyNz7g==', '김체리', '010-1234-3456', '00001', '서울시 강남구', '1');

-- venue
INSERT INTO venue(name, zonecode, address, sub_address) VALUES('KG타워 주차장', '06134', '서울 강남구 테헤란로5길 7', '');

-- vehicle
INSERT INTO vehicle(name, hour_rate, venue_id, image_url) VALUES('아반떼XD', 5000, 1, '');
INSERT INTO vehicle(name, hour_rate, venue_id, image_url) VALUES('QM3', 4000, 1, '');
INSERT INTO vehicle(name, hour_rate, venue_id, image_url) VALUES('RAY', 3000, 1, '');
INSERT INTO vehicle(name, hour_rate, venue_id, image_url) VALUES('MC20 첼로', 20000, 1, '');
INSERT INTO vehicle(name, hour_rate, venue_id, image_url) VALUES('테슬라 모델X', 11000, 1, '');

-- booking
INSERT INTO booking(vehicle_id, client_id, venue_id, date, hour) VALUES(1, 1001, 1, '2023-04-10 17:00:00', 24);
INSERT INTO booking(vehicle_id, client_id, venue_id, date, hour) VALUES(2, 1002, 1, '2023-04-10 09:00:00', 12);
INSERT INTO booking(vehicle_id, client_id, venue_id, date, hour) VALUES(1, 1003, 1, '2023-04-06 08:30:00', 24);
INSERT INTO booking(vehicle_id, client_id, venue_id, date, hour) VALUES(3, 1001, 1, '2023-04-10 10:00:00', 3);

-- borad
INSERT INTO board(client_id, client_name, title, contents, image) VALUES(1001, 'apple', 'hello', 'hello world', '');
INSERT INTO board(client_id, client_name, title, contents, image, vehicle_id) VALUES(1001, 'apple', '후기글', '후기글', '', 1);
INSERT INTO board(client_id, client_name, title, contents, type) VALUES(1001, 'apple', '공지글', '공지글', '2');

-- key 
INSERT INTO `key` VALUES((SELECT client_id FROM client WHERE id='imapple'), '2u6uir76');
INSERT INTO `key` VALUES((SELECT client_id FROM client WHERE id='banana'), '5CNAg7g8');
INSERT INTO `key` VALUES((SELECT client_id FROM client WHERE id='cherry'), 'Gy48Q2ed');

