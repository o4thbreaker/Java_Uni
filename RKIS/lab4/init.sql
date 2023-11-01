CREATE TABLE IF NOT EXISTS computers (
    id SERIAL PRIMARY KEY,
    gpu VARCHAR(255),
    cpu VARCHAR(255),
    monitor VARCHAR(255),
    ramAmount INT,
    price INT
    );

INSERT INTO computers (gpu, cpu, monitor, ramAmount, price)
VALUES
    ('GTX 1660 Super', 'i3-12000', 'LG', 16, 40000),
    ('RTX 4080 Ti', 'i7-12400f', 'Aoc', 32, 100000),
    ('Radeon r7 200', 'AMD Ryzen 3', 'LG', 4, 12000),
    ('Radeon RX Vega 8', 'AMD Ryzen 5 3500U', 'Honor', 8, 40000),
    ('GTX 1060', 'i5-10000f', 'Aoc', 8, 30000),
    ('Radeon RX 580', 'i3-9800', 'LG', 4, 14500),
    ('Radeon RX 6600 XT', 'i5-3550', 'Samsung', 16, 20000),
    ('RTX 2060 SUPER', 'AMD Ryzen 7 5700X', 'Samsung', 32, 60000);