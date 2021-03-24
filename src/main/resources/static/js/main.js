const mySwiper = new Swiper('.swiper-container', {
	loop: true,

	// Navigation arrows
	navigation: {
		nextEl: '.slider-button-next',
		prevEl: '.slider-button-prev',
	},
});

//  cart
const buttonCart = document.querySelector('.button-cart'),
	modalCart = document.querySelector('#modal-cart');

const openModal = () => modalCart.classList.add('show');
const closeModal = () => modalCart.classList.remove('show')

buttonCart.addEventListener('click', openModal);

modalCart.addEventListener('click', event => {
	if (event.target.classList.contains('overlay') || event.target.classList.contains('modal-close')) closeModal();
});

// scroll smooth
{
	const scrollLinks = document.querySelectorAll('a.scroll-link');
	for (let scrollLink of scrollLinks) scrollLink.addEventListener('click', event => {
		event.preventDefault();
		const id = scrollLink.getAttribute('href');
		document.querySelector(id).scrollIntoView({
			behavior: "smooth",
			block: "start"
		});
	})
}
