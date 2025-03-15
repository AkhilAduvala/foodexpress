SELECT VERSION();

SELECT user, host FROM mysql.user;

CREATE USER 'foodexpress_user'@'localhost' IDENTIFIED BY 'foodexpress_password';

GRANT ALL PRIVILEGES ON foodexpress.* TO 'foodexpress_user'@'localhost';

FLUSH PRIVILEGES;

CREATE TABLE customer (
    customerId INT AUTO_INCREMENT PRIMARY KEY,
    customerName VARCHAR(25),
    customerAddress VARCHAR(40),
    contactNumber VARCHAR(10)
);

Select * from customer;

INSERT INTO customer (customerName, customerAddress, contactNumber) VALUES
('AkHi Aduvala', '13-4-15/2, Hyderabad', 9876543210),
('Ashwidhi', '13-4-15/2, Hyderabad', 9876543210),
('Ravi Kumar', '45, MG Road, Bengaluru', 9876512345),
('Priya Sharma', '23, Connaught Place, Delhi', 9123456789),
('Amit Singh', '102, JP Nagar, Mumbai', 9876543120),
('Suresh Reddy', '78, KPHB Colony, Hyderabad', 9988776655),
('Neha Verma', '56, Banjara Hills, Hyderabad', 7896543210),
('Kiran Patil', '12A, Koregaon Park, Pune', 8765432109),
('Sunil Mehta', '67, Whitefield, Bengaluru', 9876532100),
('Anjali Kapoor', '89, Hauz Khas, Delhi', 7891234567),
('Vikram Iyer', '34, Anna Nagar, Chennai', 8912345678),
('Deepak Chauhan', '78, MG Road, Pune', 7896123456),
('Sneha Joshi', '90, Bopal, Ahmedabad', 9876123450),
('Rahul Desai', '101, Salt Lake, Kolkata', 8899123456),
('Nisha Malhotra', '77, Saket, Delhi', 9123678456),
('Arun Nair', '45, Indiranagar, Bengaluru', 9988771234),
('Swati Rao', '33, Jayanagar, Bengaluru', 9877543210),
('Rajesh Gupta', '87, Powai, Mumbai', 8765432190),
('Pooja Bhatt', '21, Thane, Mumbai', 7890123456),
('Aditya Saxena', '42, Gomti Nagar, Lucknow', 8123456789),
('Simran Kaur', '90, Civil Lines, Jaipur', 9876789012),
('Manoj Yadav', '15, Hazratganj, Lucknow', 8790123456),
('Megha Agarwal', '66, Rajarhat, Kolkata', 9012345678),
('Nitin Bhatia', '99, DLF Phase 3, Gurgaon', 7896541230),
('Kavya Menon', '18, Marine Drive, Kochi', 9786543210),
('Vishal Reddy', '11, Madhapur, Hyderabad', 8765432123),
('Lakshmi Narayan', '55, HSR Layout, Bengaluru', 8765456789),
('Aniket Sen', '77, Park Street, Kolkata', 9998887776),
('Shreya Jain', '25, Mansarovar, Jaipur', 7890123499),
('Ramesh Choudhary', '89, Vaishali Nagar, Jaipur', 8912345009),
('Farhan Ali', '30, Banjara Hills, Hyderabad', 7766554433),
('Isha Kapoor', '70, Sarjapur, Bengaluru', 9987654321),
('Arvind Mishra', '98, Janakpuri, Delhi', 8796543210),
('Divya Nair', '31, Perungudi, Chennai', 7893456120),
('Yash Mehta', '72, Andheri West, Mumbai', 8098765432),
('Mitali Roy', '54, Jadavpur, Kolkata', 9876781234),
('Varun Chopra', '21, Electronic City, Bengaluru', 8098654321),
('Sonia Arora', '38, Koregaon Park, Pune', 7896541230),
('Raghav Verma', '49, Malad East, Mumbai', 8765432198),
('Ayesha Khan', '90, Chandni Chowk, Delhi', 7654321980),
('Ganesh Iyer', '25, Besant Nagar, Chennai', 8098761234),
('Rohit Sharma', '57, Sector 18, Noida', 7896543456),
('Tanvi Bhardwaj', '33, Patel Nagar, Delhi', 8907654321),
('Harsha Vardhan', '89, Kukatpally, Hyderabad', 8889997776),
('Preeti Chawla', '71, Powai, Mumbai', 9098765432),
('Sahil Sharma', '41, Greater Kailash, Delhi', 8907654321),
('Anupama Reddy', '93, Jubilee Hills, Hyderabad', 7890123890),
('Vikrant Jain', '66, Nehru Place, Delhi', 9876543456),
('Sakshi Bansal', '102, Hinjewadi, Pune', 9988776654),
('Akash Ghosh', '84, New Alipore, Kolkata', 7890456123),
('Vaibhav Patel', '39, Satellite, Ahmedabad', 9988772345),
('Ritika Singh', '55, Boring Road, Patna', 7896541200),
('Pankaj Yadav', '90, Chowk, Varanasi', 8899007766),
('Shweta Tiwari', '30, Bistupur, Jamshedpur', 9876677889),
('Rahul Pillai', '77, Anna Nagar, Chennai', 8765342123),
('Lavanya Narayan', '23, Velachery, Chennai', 7654321098),
('Siddharth Deshmukh', '65, Wakad, Pune', 7892345671),
('Naveen Sharma', '38, Indirapuram, Ghaziabad', 9870123456),
('Bhavna Dutta', '99, Beliaghata, Kolkata', 8899012345),
('Akhilesh Kumar', '32, Gomti Nagar, Lucknow', 9876541234),
('Harish Kaur', '21, South City, Ludhiana', 9988665544),
('Tanuja Ahuja', '78, Goregaon, Mumbai', 7876541230),
('Mahesh Prasad', '88, Nungambakkam, Chennai', 9012345678),
('Rajiv Bhatnagar', '11, Patel Nagar, Delhi', 7766554432),
('Komal Kapoor', '14, Dadar, Mumbai', 9988771122),
('Suraj Shetty', '42, Indiranagar, Bengaluru', 9871234560),
('Avinash Reddy', '36, Miyapur, Hyderabad', 8899007766),
('Gayatri Iyer', '55, Egmore, Chennai', 7896781234),
('Sharad Sharma', '71, Viman Nagar, Pune', 9871236789),
('Anusha Pillai', '99, Bannerghatta Road, Bengaluru', 8899776655),
('Vivek Jha', '24, Rajarhat, Kolkata', 8887766554),
('Ritika Kapoor', '34, Sarita Vihar, Delhi', 9876546789),
('Anil Sharma', '88, Laxmi Nagar, Delhi', 9012346678),
('Ruchi Bajaj', '61, Mansarovar, Jaipur', 7788991122),
('Raj Shekhawat', '14, Kota Junction, Kota', 9871234567),
('Amrita Sinha', '21, Salt Lake, Kolkata', 8765321098),
('Yogesh Rane', '37, Vashi, Navi Mumbai', 9876665544),
('Kritika Dutta', '93, Andheri East, Mumbai', 8899112233),
('Sameer Saxena', '19, Kothrud, Pune', 8099876543),
('Manish Tyagi', '50, Civil Lines, Kanpur', 7890123344),
('Saranya Venkat', '22, T Nagar, Chennai', 8901234567),
('Pavan Kumar', '45, RTC X Road, Hyderabad', 8976543210);

select * from customer where customer_id = 1;


