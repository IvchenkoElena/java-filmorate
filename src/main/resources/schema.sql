CREATE TABLE IF NOT EXISTS users (
	user_id int GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
	email varchar NOT NULL,
	login varchar NOT NULL,
	name varchar NOT NULL,
	birthday date NOT NULL
);

CREATE TABLE IF NOT EXISTS friendship (
	user_id int NOT NULL REFERENCES users(user_id),
	friend_id int NOT null REFERENCES users(user_id),
	PRIMARY KEY (user_id, friend_id)
);

CREATE TABLE IF NOT EXISTS rating (
	rating_id int GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
	name varchar NOT NULL,
	description varchar NOT NULL
);

CREATE TABLE IF NOT EXISTS films (
	film_id int GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
	name varchar NOT NULL,
	description varchar NOT NULL,
	release_date date NOT NULL,
	duration int NOT NULL,
	rating_id int NOT NULL REFERENCES rating(rating_id)
);

CREATE TABLE IF NOT EXISTS genres (
	genre_id int GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
	genre_name varchar NOT NULL
);

CREATE TABLE IF NOT EXISTS film_genre (
	film_id int NOT NULL REFERENCES films(film_id),
	genre_id int  NOT NULL REFERENCES genres(genre_id),
	PRIMARY KEY (film_id, genre_id)
);

CREATE TABLE IF NOT EXISTS likes (
	film_id int NOT NULL REFERENCES films(film_id),
	user_id int NOT NULL REFERENCES users(user_id),
	PRIMARY KEY (film_id, user_id)
);

CREATE TABLE IF NOT EXISTS reviews (
    review_id int GENERATED BY DEFAULT AS IDENTITY NOT NULL PRIMARY KEY,
    content varchar NOT NULL,
    is_positive boolean NOT NULL,
    user_id int NOT NULL REFERENCES users(user_id),
    film_id int NOT NULL REFERENCES films(film_id),
    useful bigint DEFAULT 0 NOT NULL
);

CREATE TABLE IF NOT EXISTS review_likes_dislikes (
    review_id int NOT NULL REFERENCES reviews(review_id),
    user_id int NOT NULL REFERENCES users(user_id),
    is_like boolean NOT NULL,
    is_dislike boolean NOT NULL,
    PRIMARY KEY (review_id, user_id)
);