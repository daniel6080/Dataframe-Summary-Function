### **Python Projects**
1. Multivariate Analysis

Attached is the code for assignments given in the aforementioned course. This course deals with multivariate techniques both in classical and modern statistics. Multivariate statistical methods including exploratory data analysis, geometrical interpretation of multivariate data, multivariate tests of hypothesis, multivariate analysis of variance, multivariate multiple 
regression, principal components, factor analysis, discriminant analysis, cluster analysis, and multidimensional scaling are covereed. Assignments are comprised of implementing these algorithms without the use of existing automated packages. The explanation for each code can be found in the 'Report' folder.

2. Machine Learning Theory and Application

Attached is the code for assignments given in the aforementioned course. The purpose of this course is to understand the theoretical properties of several machine learning algorithms such as Decision Trees, Random Forests, Gradient Boosting, and Neural Networks. Other multivariate analysis methods such as Logistic Regression, Support Vector Machine, and Gaussian Mixture Models are also covered. Assignments are comprised of implementing these algorithms without the use of existing machine learning packages. The explanation for each code can be found in the 'Report' folder.

3. Cluster Analysis on Customer Data

Attached is the code for cluster analysis on customer data. Principal component analysis is implemented for more suitable visualization and analysis. Furthermore, widely-used clustering methods, i.e., hierarchical clustering and K-means clustering are executed in order to extract meaningful insight from the data. The clustering results are evaluated using silhouette scores and then compared using a confusion matrix. Additional cluster analyses are implemented to investigate characteristics of the clusters and possible factors influencing customer behavior.

4. Neural Network

Neural network with one input layer, one hidden layer, and one output layer via backpropagation method is implemented. (Layer size 2, 8, 1 respectively; Learning rate=0.01)
Convergence of training is shown by plotting loss versus number of epochs.

5. Population Mean Estimator

표본 자료를 통해 모평균(Population mean)을 점추정, 구간추정 (95% 신뢰수준) 하는 간단한 클래스 생성.



### **Java Projects**
1. Dice Game

두 명이 하는 주사위 게임. 두 플레이어의 점수는 처음에 10 점이고 player 1 차례부터 시작한다. player는 주사위를 던질지(roll) 아니면 차례를 다른 player 로 넘길지(skip) 선택할 수 있다. roll 했을 때 나오는 수를 상대 player 의 점수에서 뺀다. 둘 중 더 빨리 상대 점수를 0 이나 1 로 만드는 사람이 승리한다. 만약에 상대 점수가 음수가 되면 내가 진다. 자기 순서가 되었을 때 첫 번 시도는 roll이어야 한다.

2. Train Reservation

열차 예약 시스템. 열차 한 편은 3개의 객차로 편성되며, 1호는 특실(executive car), 나머지 2호와 3호는 일반실(standard car) 이다. 좌석들은 2개씩 붙어 있어, 한 열은 창측, 복도측, 복도측, 창측의 4개의 좌석으로 편성된다. 각 객차(car)는 2열 8개 좌석으로 편성된다. 열차는 오후 1시 30분, 2시 30분, 3시 30분의 세 편이 있으며, 순서대로 1, 2, 3 열차로 부른다. 처음 프로그램을 시작할 때, 각 좌석이 이미 예약되어 있을 확률을 80%라고 가정한다.
사용자가 열차 번호를 선택하면, 프로그램은 사용자가 원하는 좌석이 특실(executive)인지 일반실(standard)인지, 창측(window)인지 복도측(aisle)인지를 물어본다. 프로그램은 이 모든 조건에 맞는 좌석을 예약한다. 조건에 맞는 좌석이 없을 경우 프로그램은 사용자에게 예약에 실패했다고 알려준다.

3. Pets

petdata.txt를 읽고 output.png와 같은 output을 내는 프로그램.
Pet class 는 abstract class로서 abstract method sound()를 가진다. Dog, Cat, Bird 는 Pet 의 children이며, walking interface 를 implement 하고, 특히 Bird 는 flying interface 를 implement 하고 있다. (class diagram.png 참조)
Person 은 Pet(pet[i])들을 nPet 마리 가지고 있다.

4. Company Management

회사의 종업원(Employee)들, 상품(Product)들, 소비자(Customer)들 그리고 구매 데이터를 (어떤 customer가 어떤 상품을 샀는지) 관리하는 프로그램.
각 데이터는 다음과 같은 특징을 갖는다고 가정한다.

- Employee: 해고와 채용 빈번하며, 동명 이인이 있을 수 있다. 종업원 각각의 name 과 age 를 저장
- Product: 상품 name 과 수량 amount (정수), sold (판매완료 여부, boolean), 생산한 종업원 (employee)
를 저장. 상품은 추가만 되며 삭제는 되지 않는다.
- Customer: name 을 가진다. 같은 이름의 customer 는 허용하지 않음
- Purchase: (customer, product) 의 pair들이 모인 데이터

다음의 operation 들을 수행하고 그 결과를 프린트한다.

- Employee 5명 추가 후 임의의 위치의 2명 해고, 이후 3명을 임의의 위치에 추가
- Employee를 정렬 후 리스트를 보여줌 (정렬 기준: name, age 순서로 오름차순)
- Product 10개 추가, 정렬 후 리스트를 보여줌 (정렬 기준: name, amount, employee, sold 순서로 오름차순)
- Customer 5명 추가 후 보여 줌. 중복 허용하지 않음을 확인시켜야 함
- Purchase 7개 데이터 추가 후 보여줌



### **R Projects**
1. Dataframe Summary

Dataframe을 input으로 받아 최소값, 평균, 중앙값, 최대값, 표준편차를 행렬로 변환하는 함수 생성.

2. CLT Plot

이항분포(binomial distribution)로부터 표본 추출을 반복하는 시뮬레이션을 plotting하여 표본 평균의 분포가 근사적으로 종 모양의 정규분포를 따른다는 중심 극한 정리를 시각적으로 확인할 수 있다.

