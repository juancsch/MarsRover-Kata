/**
 * TODO list:
 * -
 *
 */

const MarsRover = require('../src/MarsRover')

const newMarsRover = function (gridDimension, initialPosition, initialFacing) {

	return MarsRover(gridDimension, initialPosition, initialFacing)
}

describe('Configuracion del entorno', function () {

	it('deberia pasar el test cuando el entorno este correctamente configurado', function () {

		expect(jest).toBeDefined()
	})
})

describe('Acceptance test MarsRover specifications', function () {

	it('The marsRover is on a 100x100 grid at location (0, 0) and facing NORTH.' +
       "The marsRover is given the commands 'ffrff' and should end up at (2, 2)", function () {

		const marsRover = newMarsRover({with: 100, heightt: 100}, {x: 0, y: 0}, 'N')
		const actual = marsRover.exec('ffrff')
		const expected = {x: 2, y: 2}

		expect(actual).toBe(expected) // `the mars rover should move to ${expected}`);
	})
})
