package com.tdd.flightmanagement;

import com.tdd.flightmanagement.models.BusinessFlight;
import com.tdd.flightmanagement.models.EconomyFlight;
import com.tdd.flightmanagement.models.Flight;
import com.tdd.flightmanagement.models.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirportTest {
    @DisplayName("Given there is an economy flight")
    @Nested
    class  EconomyFlightTest {
        private Flight economyFlight;
        private Passenger mike;
        private Passenger james;

        @BeforeEach
        void setUP(){
            economyFlight = new EconomyFlight("1");
            mike = new Passenger("Mike", false);
            james = new Passenger("James", true);
        }
        // region tdd - v1
//        @Test
//        public void testEconomyFlightRgularPassenger(){
//            Passenger mike = new Passenger("Mike", false);
//            assertEquals("1",economyFlight.getId());
//            assertEquals(true, economyFlight.addPassenger(mike));
//            assertEquals(1, economyFlight.getPassengersList().size());
//            assertEquals("Mike", economyFlight.getPassengersList().get(0).getName());
//            assertEquals(true, economyFlight.removePassenger(mike));
//            assertEquals(0, economyFlight.getPassengersList().size());
//        }
//
//        @Test
//        public void testEconomyFlightVipPassenger() {
//            Passenger james = new Passenger("James", true);
//            assertEquals("1", economyFlight.getId());
//            assertEquals(true, economyFlight.addPassenger(james));
//            assertEquals(1, economyFlight.getPassengersList().size());
//            assertEquals("James", economyFlight.getPassengersList().get(0).getName());
//            assertEquals(false, economyFlight.removePassenger(james));
//            assertEquals(1, economyFlight.getPassengersList().size());
//        }
        //endregion
        @Nested
        @DisplayName("When we have a regular passenger - Refactor")
        class RegularPassenger {
            @Test
            @DisplayName("Then you can add and remove him from economy flight")
            public void testEconomyFlightRegularPassenger(){
                assertAll("Verify all conditions for a regular passenger and an economy flight",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(mike)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size()),
                        () -> assertEquals("Mike", economyFlight.getPassengersList().get(0).getName()),
                        () -> assertEquals(true, economyFlight.removePassenger(mike)),
                        () -> assertEquals(0, economyFlight.getPassengersList().size())
                );
            }
        }
        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {
            public void testEconomyFlightVipPassenger() {
                assertAll("Verify all conditions for VIP passenger and economy flight",
                        ()-> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(james)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size()),
                        () -> assertEquals("James", economyFlight.getPassengersList().get(0).getName()),
                        () -> assertEquals(false, economyFlight.removePassenger(james)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size())
                );

            }
        }
    }



    @DisplayName("Given there is a business flight")
    @Nested
    class BusinessFlightTest {
        private Flight businessFlight;
        private Passenger mike;
        private Passenger james;

        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight("2");
            mike = new Passenger("Mike", false);
            james = new Passenger("James", true);
        }

        @Nested
        @DisplayName("When we have a regular passenger")
        class RegularPassenger {

            @Test
            @DisplayName("Then you cannot add or remove him from a business flight")
            public void testBusinessFlightRegularPassenger() {
                assertAll("Verify all conditions for a regular passenger and a business flight",
                        () -> assertEquals(false, businessFlight.addPassenger(mike)),
                        () -> assertEquals(0, businessFlight.getPassengersList().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(mike)),
                        () -> assertEquals(0, businessFlight.getPassengersList().size())
                );
            }
        }

        @Nested
        @DisplayName("When we have a VIP passenger")
        class VipPassenger {

            @Test
            @DisplayName("Then you can add him but cannot remove him" +
                    "from a business flight")
            public void testBusinessFlightVipPassenger() {
                assertAll("Verify all conditions for a VIP passenger and" +
                        "a business flight",
                        () -> assertEquals(true, businessFlight.equals(james)),
                        () -> assertEquals(1, businessFlight.getPassengersList().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(james)),
                        () -> assertEquals(1, businessFlight.getPassengersList().size())
                        );
            }
        }
        // region tdd-v1
//        @Test
//        public void testBusinessFlightRegularPassenger() {
//            Passenger mike = new Passenger("Mike", false);
//
//            assertEquals(false, businessFlight.addPassenger(mike));
//            assertEquals(0, businessFlight.getPassengersList().size());
//            assertEquals(false, businessFlight.removePassenger(mike));
//            assertEquals(0, businessFlight.getPassengersList().size());
//        }
//
//        @Test
//        public void testBusinessFlightVipPassenger() {
//            Passenger james = new Passenger("James", true);
//
//            assertEquals(true, businessFlight.addPassenger(james));
//            assertEquals(1, businessFlight.getPassengersList().size());
//            assertEquals(false, businessFlight.removePassenger(james));
//            assertEquals(1, businessFlight.getPassengersList().size());
//        }
        //endregion
    }
}
