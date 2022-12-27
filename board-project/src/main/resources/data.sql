-- 테스트 계정
insert into user_account (user_id, user_password, nickname, email, memo, created_at, created_by, modified_at, modified_by) values
                    ('Taeheon','rlaxogjs8312','너굴맨','tae77777@naver.com','반갑습니다.',now(),'taeheon',now(),'taeheon')
;


-- 게시글 13개
insert into article (title, content, hashtag, created_by, modified_by, created_at, modified_at) values
                    ('Quisque ut erat.', 'Vestibulum quam sapien, varius ut, bla',
                        '#pink', 'Kamilah', 'Murial', '2021-05-30 23:53:46', '2021-03-10 08:48:50'),
                    ('Morbi ut odio.', 'Phasellus in felis.Integer ac leo.s odio. Donec vitae nisi.',
                        '#purple', 'Arv', 'Keelby', '2021-05-06 11:51:24', '2021-05-23 08:34:54'),
                    ('Vestibulum', 'Etiam vel augue. Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.',
                        '#purple', 'Adams', 'Thalia', '2021-08-13 08:32:22', '2021-04-02 02:58:19'),
                    ('Fusce posuere felis sed lacus.', 'Integer ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi.',
                        '#mauv', 'Johny', 'Constantin', '2021-09-05 04:28:16', '2021-10-31 17:46:08'),
                    ('Aliquam erat volutpat.', 'Proin inpien iaculis molestie, hendrerit at, vulputate vitae, nisl.',
                        '#green', 'Karlene', 'Marmaduke', '2022-01-25 16:10:23', '2021-11-08 08:47:03'),
                    ('Donec ut mauris', 'Cras non veacat. Quisque erat e eget, congue eget, semper rutruma. Nunc purus.',
                        '#maroon', 'Alonso', 'Eustacia', '2022-01-26 06:33:42', '2021-12-08 11:27:30'),
                    ('Nullam in lectus.', 'Proi. Ut at dolor quis odio cue ultrices mattis odio. Donec vitae nisi.',
                        '#orange', 'Dedra', 'Wilek', '2021-05-04 19:51:29', '2021-10-09 16:52:09'),
                    ('Sed ante.', 'Fusce posuerede libero quis orci. Nullam molestie nibh in lectus.',
                        '#teal', 'Doe', 'Jodi', '2021-10-23 23:45:21', '2021-08-05 14:19:36'),
                    ('Inhabitassest.', 'Sed an ut mauris eget massa  convallis eget, eleifend luctus, ultricies eu, nibh.',
                        '#khaki', 'Fitz', 'Jemmie', '2021-01-10 21:03:03', '2021-04-15 05:02:39'),
                    ('Vivamus.', 'Nulllla facmus .s, viverra eget, congue eget, semper rutruma. Nunc purus.',
                        '#puce', 'Grace', 'Bryn', '2021-09-28 07:01:29', '2021-09-01 13:54:55'),
                    ('Morbi.', 'Maur lobortis co lacinia sapien quis libero.',
                        '#orange', 'Lalo', 'Lorrie', '2022-01-26 03:40:15', '2021-07-18 05:30:34'),
                    ('Cum slu', 'Sed ante. Vivamus tortobero, convallis eget, eleifend luctus, ultricies eu, nibh.',
                        '#purple', 'Jane', 'Tresa', '2021-07-22 22:25:07', '2021-05-16 14:20:27'),
                    ('Duis ', 'Curabitur od Maecenas pulvinar lobortis est.',
                        '#maroon', 'Cookie', 'Rosalia', '2021-02-20 10:06:13', '2021-10-10 06:05:30')
;


-- 댓글 2개
insert into article_comment (article_id, content, created_at, modified_at, created_by, modified_by) values
                     (1, 'Quisque idNulla dapibeugiat et, eros.', '2021-03-02 22:40:04', '2021-04-27 15:38:09', 'Lind', 'Orv'),
                     (2, '안녕하세요','2022-12-23 14:18:00','2022-12-23 14:18:00','김태헌','김태헌')
;
