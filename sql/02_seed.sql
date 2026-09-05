-- Seed data: 10 movies and 10 reviews.
--
-- Usage: psql -d moviesv2 -f sql/02_seed.sql

TRUNCATE TABLE reviews, movies RESTART IDENTITY CASCADE;

INSERT INTO movies (title, genre) VALUES
    ('The Shawshank Redemption', 'Drama'),
    ('Inception',                'Science Fiction'),
    ('The Godfather',            'Crime'),
    ('Spirited Away',            'Animation'),
    ('Mad Max: Fury Road',       'Action'),
    ('Parasite',                 'Thriller'),
    ('The Grand Budapest Hotel', 'Comedy'),
    ('Alien',                    'Horror'),
    ('Casablanca',               'Romance'),
    ('Blade Runner 2049',        'Science Fiction');

INSERT INTO reviews (movie_id, rating, comment) VALUES
    (1,  10, 'A perfect film about hope and patience.'),
    (2,   9, 'Ambitious and endlessly rewatchable.'),
    (3,  10, 'The benchmark every crime drama is measured against.'),
    (4,   9, 'Gorgeous animation and a story with real weight.'),
    (5,   8, 'Two hours of practical-effects mayhem. No filler.'),
    (6,   9, 'Sharp, funny, and then quietly devastating.'),
    (7,   8, 'Every frame looks composed with a ruler.'),
    (8,   9, 'Still the best haunted-house-in-space movie ever made.'),
    (9,   8, 'Holds up almost a century later.'),
    (10,  7, 'Stunning to look at, though it takes its time.');
