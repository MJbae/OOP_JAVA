# OOP_JAVA 

## 1. OOP 목적

코드의 가독성과 재사용성을 높여서 유지보수를 쉽게 하는 것

## 2. OOP 핵심 개념

> "객체지향의 목표는 실세계를 모방하는 것이 아니다. 오히려 새로운 세계를 창조하는 것" 
-조영호

## 3. 인터페이스와 추상 클래스의 활용

### 가. 추상체와 재사용성

- 특정 코드의 대한 재사용성을 높이기 위해서 사용방법(시그니처)에 대해 정립
- 해당 코드의 생산자와 사용자는 사용방법을 따르기로 계약
- 본 계약은 생산자가 만든 함수의 시그니처를 사용자에게 따를 것을 강제함

    → 사용자 임의로 특정 코드의 틀을 바꾸면 재사용성이 떨어짐

- 인터페이스와 추상 클래스의 추상메소드를 구현하지 않으면 컴파일 불가

    → 인터페이스와 추상 클래스의 추상메소드가 재사용성을 위한 일종의 계약

### 나. 추상 클래스 vs 인터페이스

- 사용 방법

    → 추상 클래스: 엄격한 is-a 관계(부모-자식 간 상속 관계)에 사용됨

    개와 고양이는 모두 포유류 클래스를 상속 받는 관계며, 추상 메소드를 각각 구현하고 추상 클래스에 구현된 generateHeat을 상속 받아서 사용함

    ```java
    public abstract class Mammal {
    	public void generateHeat() { System.out.println("Generate Heat"};
    	public abstract void makeNoise();
    }

    public class Dog extends Mammal {
    	public void makeNoise() {System.out.println("Bark"};
    }

    public class Cat extends Mammal {
    	public void makeNoise() {System.out.println("Naaa"};
    }
    ```

    → 인터페이스: 엄격하지 않은 관계에서 사용됨

    개와 도마뱀은 각각 포유류와 파충류의 추상클래스를 상속 받는 관계이나, 모두 이름을 필요로 하므로 상속관계와 관계 없어 interface의 추상 메소드를 받아서 구현함

    ```java
    public interface Nameable {
    	public String getName();
    	public void setName(String aName);
    }

    public class Dog extends Mammal implements Nameable {
    	String dogName;
    	public String getName() { return dogName; }
    	public void setName(String myName) { dogName = myName};
    }

    public class lizard extends Reptile implements Nameable {
    	String lizardName;
    	public String getName() { return lizardName; }
    	public void setName(String myName) { lizardName= myName};
    }

    ```

- 기능적 차이

    → 추상 클래스: 추상 메소드 한 개 이상 포함 + 구상 메소드 포함 가능

    → 인터페이스: 오직 추상 메소드만 포함

- 다중 상속

    → 추상 클래스: 다중 상속 지원 X

    → 인터페이스: 다중 상속 지원 O

## 4. 책임-주도 설계 절차

1. 유스케이스 작성  2. 도메인 모델 설계  3. 책임-주도 설계로 통합

### 가. 기능: 유스케이스 작성

유스케이스에서 최초의 책임(시스템 책임, 가장 거대한 책임)을 이끌어 낼 수 있음

- 유스케이스(Use Case): 사용자가 시스템을 활용하는 과정 전반에 대한 것을 텍스트로 정리한 것

    ex) 유스케이스 요약: 예금주(사용자)는 중도 해지 이자액을 알고 싶다

    주요 시나리오

    1. 예금주가 정기예금 계좌를 선택한다
    2. 시스템은 정기예금 계좌 정보를 보여준다
    3. 예금주가 금일 기준으로 예금을 해지할 경우 지급받을 수 있는 이자 계산을 요청한다
    4. 시스템은 중도 해지 시 지급받을 수 있는 이자를 계산한 후 결과를 사용자에게 제공한다

### 나. 구조: 도메인 모델 설계

도메인 모델을 통해 변경 가능성이 적은(근본적인) 구조를 찾아낼 수 있음

- 도메인 모델: 관심을 갖는 특정 영역에 대해 추상적이지만 간단한 구조를 만드는 것

    → 도메인: 관심을 갖는 특정 영역에 대해 사용자가 가지고 있는 이미지

    → 모델: 특정 지식에 대해 강조하고 축소하여, 추상적이지만 간단한 구조를 만드는 것

    ex) 정기예금(기간, 해지여부) - 계좌(계좌번호, 예금액) - 이자율(금리) - 이자(금액, 지금일자)

- 도메인 모델 설계 시 주의할점: 도메인 설계 시, 사용자의 입장에서 구조를 잡을 것

    → 도메인 모델 작성 시, 설계자가 그리는 모델과 실제 사용자가 그리는 모델 간에 차이가 발생할 수 있음

    → 새로운 서비스를 설계할 때, 기존에 존재하지 않았던 서비스라면 사용자가 해당 서비스에 대해 어떤 이미지를 가지고 있는 지 알 수 없기 때문임

### 다. 통합: 책임-주도 설계

- 책임-주도 설계 목적: 기능의 불안정성을 안정적인 구조에 통합하는 과정을 구체화함

    → 기능의 불안정성과 직관성을 구조의 안정성과 추상성을 구체적인 절차에 따라 통합함

- 설계 과정
- 1) 시스템 기능을 파악: 유스케이스를 통해 시스템 책임(최초의 책임)을 파악함

    ex) 예금주가 금일 기준으로 예금을 해지할 경우 지급받을 수 있는 이자 계산을 요청한다

- 2) 시스템 기능을 객체의 책임으로 변환

    → **강조) 객체 보다 중요한 것은 메시지임. 메시지를 구체화하고 해당 메시지에 적합한 객체를 선택할 것**

    → 객체를 선택할 때, 도메인 모델의 구조에서 해당되는 개념을 차용함

- 3) 객체의 책임을 더 작은 책임으로 분할

    ex) '정기예금' 객체는 해지 일자를 전달받아서 이자 계산을 시작하는 책임을 갖는다

    '정기예금' 객체는 해당 일자가 약정 기간에 포함되는 지 확인하는 책임을 갖는다

    '정기예금' 객체는 해당 일자가 약정 기간에 포함되면 '이자' 객체에게 이자 계산을 요청한다 

    ~~ 

    객체지향의 사실과 오해, p200 참고

- 4) 분할된 책임을 수행할 객체를 생성하거나 찾아서 해당 책임을 할당함

    → 마찬가지로 분할된 책임을 맡을 객체를 생성하거나 찾기 전에 해당 책임이 담긴 메세지를 구체화하고 이 메세지에 어울리는 객체를 탐색할 것

- 5) 4번의 객체가 해당 책임을 수행하는데 도움이 필요한 경우, 협력할 역할 또는 객체를 찾음
- 6) 해당 역할 또는 객체에게 협력에 대한 책임을 할당함으로써 협력 관계를 만듬
- 책임과 협력 관계가 모두 파악이 되면 클래스 변환함
- **대부분 구현단계에서 설계한 부분이 수정되므로 설계는 큰 틀에서 빠르게 작성하고 구현 단계를 거치면서 수정할 것**

## 5. SOLID 원칙

### 가. SOLID 원칙 도입 배경

- 현실세계의 관계를 그대로 코드로 옮길 경우, 설계적 문제 발생
- 설계적 문제란 재사용성이 매우 떨어지는 코드가 생산되는 것
- 소프트웨어 설계의 이해를 돕고, 재사용성을 높이며 유지보수를 편리하게 하기 위해 SOLID 원칙 제시
- 재사용성이 떨어지는 코드는 다음의 특징이 있음

    → 경직성: 프로그램의 일부분에 대한 수정에 따라 다른 부분도 수정해야 함

    → 취약성: 오류의 원인이 뜬금없는 곳에서 있음

    → 부동성: 이식이 불가능함(or 다른 부분에 재사용이 불가능함)

### 나. SRP(Single Responsibility Principle)

- 단일책임 원칙 목표: 하나의 메소드에 대한 변경이 다른 메소드에 영향을 주지 않는 것

    → 불필요하게 컴파일 하지 않는 것

- 하나의 클래스는 하나의 기능(or 책임)을 수행함

    → 특정 클래스에 대한 주석을 명시할 때, '그리고'라는 설명이 추가되면 SRP가 위반되는 경우로 해석 가능

- ICalculator 인터페이스에는 직선과 삼각형 그리고 사각형에 대한 계산 등 세 가지의 기능이 포함되어 있기 때문에 SRP의 원칙에 위배됨

```java
public interface ICalculator {
    double calLine(Coordinate first, Coordinate second);
    double calTriangle(Coordinate first, Coordinate second, Coordinate third);
    double calSquare(Coordinate first, Coordinate second, Coordinate third, Coordinate forth);
}

// to

// 바꿔보자
```

### 다. OCP(Open/Close Principle)

- 개방/폐쇄 원칙 목표: 기존 클래스에 대한 변경 없이 코드를 확장하는 것

    → 레거시 코드에 대한 걱정 없이 시스템 확장 가능

- 부모 클래스에 대한 변경 없이 자식 클래스를 통해서만 코드를 확장함

    → 부모 클래스에 대한 변경이 더이상 없기 때문에 Closed

    → 요구사항에 따라 자식 클래스는 계속 확장하기 때문에 Open

- 이하 예제에서 Rectangle을 부모클래스로 설계하면 Circle의 calArea를 구할 때 부모 클래스를 변경해야 함

    → Circle의 넓이를 구할 때, 지름이라는 추가적인 변수가 필요함

    → Shape이라는 추상 클래스를 만들고 추상 메소드로 getArea()를 선언하면 이하 자식 클래스 Rectangle과 Circle을 생성하면 다른 부모 코드에 대한 수정을 가하지 않아도 됨

```java
class Rectangle{}
class CalculateArea{
	// 생략
	public double calcArea(Rectangle r){
	}
}
```

### 라. LSP(Liskov Substitution Principle)

- 리스코프 대체 원칙 목표: 부모 클래스의 필드와 메소드는 모든 자식 클래스에서 편법 없이 그대로 사용해야 함

    → 설계에 일관성이 결여되면 의도하지 않은 유지보수 문제로 이어질 수 있음

- 이하 예제를 보면, Square의 생성자는 부모 클래스인 Rectangle 생성자와 달리 매개변수를 1개만 전달 받음. super() 사용하여 기능면에서는 문제가 없지만 설계의 일관성이 결여되었기에 추후에 문제 발생 여지가 있음

```java
abstract class Shape {
}

class Rectangle extends Shape {
		public Rectangle(double l, double w){
		}
}

class Square extends Rectangle {
		public Square(double s) {
			super(s, s);
		}
}
```

### 마. ISP(Interface Segregation Principle)

- 인터페이스 분리 원칙 목표: 큰 단위의 인터페이스 보다 작은 단위의 인터페이스를 다수 생성

    → 여러 인터페이스를 합성하여 객체를 설계하는 것이 추후 예상치 못한 확장에 대처할 때 유리

- Interface를 아래와 같이 작은 단위로 쪼개면 추후 시스템 확장 시 요구사항을 정확하게 맞출 수 있음

```java
interface IEat {
	public void eat();
}

interface IAbsorbElectronic {
	public void absorbElectronic();
}

interface IMakeNoise {
	public void makeNoise();
}

class Dog implements IEat, IMakeNoise {
}

class Keyboard implements IAbsorbElectronic, IMakeNoise {
}
```

### 바. DIP(Dependency Inversion Principle)

- 의존성 역전 원칙 목표: 추상화에 의존하여 코드가 결합되어야 함

    → 추상화에 의존한 설계가 된다면 객체의 구상화는 컴파일 타임이 아니라 런 타임에 이루어짐

- 의존성 역전을 위해 객체에서 행위 부분을 다른 객체로 분리함

    → 해당 행위 부분은 상속관계가 아닌 객체에서도 사용 가능(재사용성 Up)

```java
public class DIP {
    public static void main(String[] args){
        Mammal cat = new Mammal(new CatNoise());
        Mammal dog = new Mammal(new DogNoise());

        System.out.println(cat.makeNoise());
        System.out.println(dog.makeNoise());
    }
}

interface MakingNoise {
    abstract String makeNoise();
}

class CatNoise implements MakingNoise {
    @Override
    public String makeNoise() {
        return "Na";
    }
}

class DogNoise implements MakingNoise {
    @Override
    public String makeNoise() {
        return "Bark";
    }
}

class Mammal {
    MakingNoise speaker;

    public Mammal(MakingNoise sp){
        this.speaker = sp;
    }
    public String makeNoise(){
        return this.speaker.makeNoise();
    }
}
```

## Reference

- Matt Weisfeld, The Object-Oriented Thought Process
- 조영호, 객체지향의 사실과 오해
